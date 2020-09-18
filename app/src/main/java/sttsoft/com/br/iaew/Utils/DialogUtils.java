package sttsoft.com.br.iaew.Utils;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import sttsoft.com.br.iaew.Models.interfaces.DialogAction;
import sttsoft.com.br.iaew.R;

public class DialogUtils {

    private static final String TAG = "Dialog Utils";

    public static AlertDialog show(Context context, String title, String msg, String ok, DialogAction action, boolean cancelable) {
        try {

            View v = LayoutInflater.from(context).inflate(R.layout.dialog_padrao, null);
            TextView tvTitle = v.findViewById(R.id.tvTitle);
            TextView tvMsg = v.findViewById(R.id.tvMsg);
            Button btnP = v.findViewById(R.id.btnPositivo);
            Button btnN = v.findViewById(R.id.btnNegativo);
            Button btnNe = v.findViewById(R.id.btnNeutro);

            btnN.setVisibility(View.GONE);
            btnNe.setVisibility(View.GONE);

            btnP.setText(ok);


            tvTitle.setText(title);
            tvMsg.setText(msg);

            AlertDialog dialog = new AlertDialog.Builder(context)
                    .setView(v)
                    .setNegativeButton("", null)
                    .setPositiveButton("", null)
                    .setCancelable(cancelable)
                    .create();

            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

            btnP.setOnClickListener(view -> action.onPositive(dialog));

            return dialog;
        } catch (Exception ex) {
            Log.e(TAG, "show: ", ex);
            return null;
        }
    }
}
