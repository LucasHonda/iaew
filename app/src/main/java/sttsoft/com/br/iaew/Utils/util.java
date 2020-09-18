package sttsoft.com.br.iaew.Utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import java.io.File;

public class util {
    /**
     * Obtem retorno das informações referente a package (APP)
     *
     * @param context
     * @return
     */
    public static PackageInfo getInfoApp(Context context) throws Exception {
        PackageManager pm = context.getPackageManager();
        return pm.getPackageInfo(context.getPackageName(), 0);
    }

    /**
     * Obtem diretorio do app
     *
     * @param context
     * @return File
     */
    public static File getAppDir(Context context) throws Exception {
        PackageManager packageManager;
        String packageName;
        PackageInfo packageInfo;
        File file;

        packageManager = context.getPackageManager();
        packageName = context.getPackageName();

        packageInfo = packageManager.getPackageInfo(packageName, 0);
        file = new File(packageInfo.applicationInfo.dataDir);

        return file;
    }

    public static File getDiretorioRealm(Context context) throws Exception {
        File file = new File(getAppDir(context), "realm/");

        if (!file.exists())
            file.mkdirs();

        return file;
    }
}
