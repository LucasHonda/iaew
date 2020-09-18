package sttsoft.com.br.iaew.Views;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.microsoft.signalr.HubConnection;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Single;
import sttsoft.com.br.iaew.Domains.Chat.AdapterChat;
import sttsoft.com.br.iaew.Domains.Connection.ConnectionFactory;
import sttsoft.com.br.iaew.Models.model.Message;
import sttsoft.com.br.iaew.Models.model.SingleMessage;
import sttsoft.com.br.iaew.R;

public class ChatActivity extends AppCompatActivity {

    private static final String TAG = "Chat Activity";

    @BindView(R.id.lstMsgs) RecyclerView lstMsgs;
    @BindView(R.id.edtMsg) EditText edtMsg;
    @BindView(R.id.btnSend) ImageButton btnSend;

    private AdapterChat adapter;

    private ArrayList<Message> mArrMsgs = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        ButterKnife.bind(this);

        try {

            lstMsgs.setLayoutManager(new LinearLayoutManager(this));
            lstMsgs.getRecycledViewPool().setMaxRecycledViews(0,0);

            adapter = new AdapterChat(mArrMsgs);

            lstMsgs.setAdapter(adapter);



            //btnSend.setOnClickListener(v -> {
            //    connection.send("SendSingleMessage", new SingleMessage("8", "6", edtMsg.getText().toString()));
            //});

        } catch (Exception ex) {
            Log.e(TAG, "onCreate: ", ex);
        }
    }

}
