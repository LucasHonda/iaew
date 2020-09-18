package sttsoft.com.br.iaew.Models.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import lombok.Data;

@Data
public final class Usuario {

    private final String TAG = "Usuario";
    private final String UserChat = "user_chat";
    private final String UserData = "user_data";
    private final String UserLogged = "user_logged";


    private String id;
    private String name;
    private boolean active;
    private String login;

    private static Usuario instance;

    public static synchronized Usuario getInstance() {
        if (instance == null)
            instance = new Usuario();

        return instance;
    }

    private Usuario(){}

    public void setUsuario(String id, String name, boolean active, String login, Context context) {
        this.id = id;
        this.name = name;
        this.active = active;
        this.login = login;

        try {
            SharedPreferences prefs = context.getSharedPreferences(UserChat, Context.MODE_PRIVATE);
            Editor editor = prefs.edit();

            editor.putString(UserData, new Gson().toJson(this.getUsuario()));
            editor.putBoolean(UserLogged, true);
            editor.apply();
        } catch (Exception ex) {
            Log.e(TAG, "setUsuario: ", ex);
        }
    }

    private void setUsuario(Usuario u) {
        this.id = u.getId();
        this.name = u.getName();
        this.active = u.isActive();
        this.login = u.getLogin();
    }

    public boolean isLogged() {
        return this.id != null && !this.id.isEmpty();
    }

    public Usuario getUser(Context context) {

        try {
            SharedPreferences prefs = context.getSharedPreferences(UserChat, Context.MODE_PRIVATE);

            if (!prefs.getBoolean(UserLogged, false))
                return null;

            setUsuario(new Gson().fromJson(prefs.getString(UserData, ""), Usuario.class));

            return getUsuario();

        } catch (Exception ex) {
            Log.e(TAG, "getUser: ", ex);
            return null;
        }
    }

    private Usuario getUsuario() {
        return this;
    }

    public void logout(Context context) {
        try {
            SharedPreferences prefs = context.getSharedPreferences(UserChat, Context.MODE_PRIVATE);
            Editor editor = prefs.edit();

            editor.putBoolean(UserLogged, false);
            editor.apply();
            prefs.edit().clear();
        } catch (Exception ex) {
            Log.e(TAG, "logout: ", ex);
        }
    }
}
