package sttsoft.com.br.iaew.Models.interfaces;

import android.app.AlertDialog;

public interface DialogAction {
    void onPositive(AlertDialog dialog);
    void onNegative(AlertDialog dialog);
    void oNeutral(AlertDialog dialog);
}
