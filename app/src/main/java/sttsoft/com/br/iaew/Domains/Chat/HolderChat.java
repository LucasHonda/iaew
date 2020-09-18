package sttsoft.com.br.iaew.Domains.Chat;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import sttsoft.com.br.iaew.R;

public class HolderChat extends RecyclerView.ViewHolder {

    public TextView lblFrom;
    public TextView lblTime;
    public TextView lblMessage;

    public HolderChat(@NonNull View itemView) {
        super(itemView);

        lblFrom = itemView.findViewById(R.id.lblFrom);
        lblTime = itemView.findViewById(R.id.lblTime);
        lblMessage = itemView.findViewById(R.id.lblMessage);
    }
}
