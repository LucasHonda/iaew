package sttsoft.com.br.iaew.Domains.Channels;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import de.hdodenhof.circleimageview.CircleImageView;
import sttsoft.com.br.iaew.R;

public class HolderChannel extends RecyclerView.ViewHolder {

    public CircleImageView c_img;
    public TextView c_channel_name;
    public TextView c_last_msg;
    public TextView c_time;

    public HolderChannel(@NonNull View itemView) {
        super(itemView);
        c_img = itemView.findViewById(R.id.c_img);
        c_channel_name = itemView.findViewById(R.id.c_channel_name);
        c_last_msg = itemView.findViewById(R.id.c_last_msg);
        c_time = itemView.findViewById(R.id.c_time);
    }
}
