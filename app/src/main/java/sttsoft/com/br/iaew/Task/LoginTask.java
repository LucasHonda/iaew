package sttsoft.com.br.iaew.Task;

import android.app.AlertDialog;
import android.content.Context;
import android.hardware.usb.UsbDevice;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONObject;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sttsoft.com.br.iaew.Models.interfaces.DialogAction;
import sttsoft.com.br.iaew.Models.model.Usuario;
import sttsoft.com.br.iaew.Models.retrofit.service;
import sttsoft.com.br.iaew.Utils.DialogUtils;
import sttsoft.com.br.iaew.Utils.JsonUtils;
import sttsoft.com.br.iaew.Utils.Retrofit.webservice;

import static sttsoft.com.br.iaew.Utils.JsonUtils.*;

public class LoginTask extends AsyncTask<Void, Void, Boolean> {

    private static final String TAG = "Login Task";

    private String login;
    private String password;
    private Runnable run;
    private Context context;

    public LoginTask(String login, String password, Runnable run, Context con) {
        this.login = login;
        this.password = password;
        this.run = run;
        this.context = con;
    }

    @Override
    protected Boolean doInBackground(Void... voids) {
        try {

            final service serv = webservice.createService(service.class);

            JSONObject body = new JSONObject();
            body.put("Login", login);
            body.put("Password", password);

            MediaType mediaType = MediaType.parse("application/json");
            RequestBody bd = RequestBody.create(mediaType, body.toString());

            Call<ResponseBody> call = serv.login(bd);

            call.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    try {
                        JSONObject obj = new JSONObject(response.body().string());


                        if (!getString(obj, "message", "").isEmpty()) {

                            DialogUtils.show(context, "Aviso", getString(obj, "message", ""), "OK", new DialogAction() {
                                @Override
                                public void onPositive(AlertDialog dialog) {
                                    dialog.dismiss();
                                }

                                @Override
                                public void onNegative(AlertDialog dialog) {}

                                @Override
                                public void oNeutral(AlertDialog dialog) {}
                            }, true).show();

                        } else {
                            Usuario.getInstance().setUsuario(getString(obj, "id", ""), getString(obj, "name", ""), getBoolean(obj, "active", false), getString(obj, "login", ""), context);

                            run.run();
                        }

                    } catch (Exception ex) {
                        Log.e(TAG, "onResponse: ", ex);
                    }
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    System.out.println(t);
                }
            });

            return true;
        } catch (Exception ex) {
            Log.e(TAG, "doInBackground: ", ex);
            return false;
        }
    }
}
