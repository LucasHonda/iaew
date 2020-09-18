package sttsoft.com.br.iaew.Utils;

import org.json.JSONObject;

public abstract class JsonUtils {

    public static int getInt(JSONObject obj, String campo, int defaultValue) {
        try {
            return obj.getInt(campo);
        } catch (Exception ex) {
            return defaultValue;
        }
    }

    public static String getString(JSONObject obj, String campo, String defaultValue) {
        try {
            return obj.getString(campo);
        } catch (Exception ex) {
            return defaultValue;
        }
    }

    public static Boolean getBoolean(JSONObject obj, String campo, Boolean defaultValue) {
        try {
            return obj.getBoolean(campo);
        } catch (Exception ex) {
            return defaultValue;
        }
    }

}
