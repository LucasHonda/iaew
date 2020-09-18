package sttsoft.com.br.iaew.Domains.Chat;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import sttsoft.com.br.iaew.Models.model.Message;
import sttsoft.com.br.iaew.R;

public class AdapterChat extends RecyclerView.Adapter<HolderChat> {

    private static final String TAG = "Adp Chat";

    private DateFormat format = new SimpleDateFormat("HH:mm");

    private ArrayList<Message> mArr;

    public AdapterChat(ArrayList<Message> mArr) {
        this.mArr = mArr;
    }

    @NonNull
    @Override
    public HolderChat onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HolderChat(LayoutInflater.from(parent.getContext()).inflate(R.layout.model_msg, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull HolderChat holder, int position) {
        final Message m;
        try {

            m = mArr.get(position);

            holder.lblFrom.setText(m.getFrom());
            holder.lblMessage.setText(m.getMessage());
            //holder.lblTime.setText(format.format(m.getData()));

        } catch (Exception ex) {
            Log.e(TAG, "onBindViewHolder: ", ex);
        }
    }

    @Override
    public int getItemCount() {
        return mArr.size();
    }
}
