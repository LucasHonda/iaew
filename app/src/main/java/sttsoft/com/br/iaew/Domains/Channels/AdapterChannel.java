package sttsoft.com.br.iaew.Domains.Channels;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.amulyakhare.textdrawable.TextDrawable;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import sttsoft.com.br.iaew.Models.model.Channel;
import sttsoft.com.br.iaew.R;

public class AdapterChannel extends RecyclerView.Adapter<HolderChannel> {

    private static final String TAG = "Adp Channel";

    private DateFormat formatter = new SimpleDateFormat("HH:mm");

    private ArrayList<Channel> mArr;
    private Context context;

    public AdapterChannel(ArrayList<Channel> mArr, Context context) {
        this.mArr = mArr;
        this.context = context;
    }

    @NonNull
    @Override
    public HolderChannel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HolderChannel(LayoutInflater.from(parent.getContext()).inflate(R.layout.model_channel, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull HolderChannel holder, int position) {
        final Channel c;
        try {

            c = mArr.get(position);

            holder.c_channel_name.setText(c.getChannel());

            Bitmap decodedByte = BitmapFactory.decodeByteArray(c.getImg(), 0, c.getImg().length);

            if (decodedByte != null)
                holder.c_img.setImageBitmap(decodedByte);
            else {
                String name = c.getChannel().substring(0,2);

                TextDrawable drawable = TextDrawable.builder().buildRound(name, context.getResources().getColor(R.color.colorPrimary));

                holder.c_img.setBackground(drawable);
            }

            holder.c_last_msg.setText(c.getLastMsg());

            holder.c_time.setText(formatter.format(c.getLastAccess()));


        } catch (Exception ex) {
            Log.e(TAG, "onBindViewHolder: ", ex);
        }
    }

    @Override
    public int getItemCount() {
        return mArr.size();
    }
}
