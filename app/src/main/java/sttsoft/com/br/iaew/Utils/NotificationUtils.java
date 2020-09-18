package sttsoft.com.br.iaew.Utils;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;

import androidx.core.app.NotificationCompat;

import sttsoft.com.br.iaew.R;

public class NotificationUtils {

    public static void openNotification(String from, String msg, Context context) {

        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        String channel = "Received";

        Notification notification = new NotificationCompat.Builder(context, channel)
                .setSmallIcon(R.drawable.ic_notify)
                .setContentTitle(from)
                .setContentText(msg)
                .build();

        manager.notify(0, notification);
    }
}
