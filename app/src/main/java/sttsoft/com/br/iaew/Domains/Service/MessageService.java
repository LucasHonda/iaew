package sttsoft.com.br.iaew.Domains.Service;

import android.app.IntentService;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.core.app.JobIntentService;

import com.microsoft.signalr.HubConnection;

import java.sql.Connection;
import java.util.List;

import sttsoft.com.br.iaew.Domains.Channels.daoChannels;
import sttsoft.com.br.iaew.Domains.Connection.ConnectionFactory;
import sttsoft.com.br.iaew.Models.model.Message;
import sttsoft.com.br.iaew.Models.model.Usuario;
import sttsoft.com.br.iaew.Models.realm.Users;
import sttsoft.com.br.iaew.Utils.NotificationUtils;

public class MessageService extends IntentService {

    private static final String TAG = "Msg Service";

    public MessageService() {
        super("Messages");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        try {
            String dataString = intent.getDataString();

            ConnectionFactory.getInstance().getNewConnection(Usuario.getInstance().getId());

            ConnectionFactory.getInstance().getConnection().on("single-message-received", (message) -> {

                try {

                    // salva no banco


                    // mostra notificacao
                    NotificationUtils.openNotification(message.getFrom(), message.getMessage(), getApplicationContext());

                    // mostra em tela

                } catch (Exception ex) {
                    Log.e(TAG, "onCreate: ", ex);
                }

            }, Message.class);

            ConnectionFactory.getInstance().getConnection().on("update-online-users", () -> ConnectionFactory.getInstance().getConnection().send("GetAvailableUsers"));

            ConnectionFactory.getInstance().getConnection().on("set-available-users", (obj) -> {



            }, Object.class);
        } catch (Exception ex) {
            Log.e(TAG, "onHandleIntent: ", ex);
        }
    }
}
