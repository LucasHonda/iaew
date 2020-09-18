package sttsoft.com.br.iaew.Views;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import sttsoft.com.br.iaew.Models.interfaces.IActivityModel;
import sttsoft.com.br.iaew.Models.model.Usuario;
import sttsoft.com.br.iaew.R;
import sttsoft.com.br.iaew.Task.LoginTask;
import sttsoft.com.br.iaew.Utils.util;

public class LoginActivity extends AppCompatActivity implements IActivityModel {

    private static final String TAG = "Login Activity";

    private Context context;

    @BindView(R.id.edtLogin) EditText edtLogin;
    @BindView(R.id.edtSenha) EditText edtSenha;
    @BindView(R.id.btnLogin) Button btnLogin;
    @BindView(R.id.lblEsqueceuSenha) TextView lblEsqueceuSenha;
    @BindView(R.id.lblCadastro) TextView lblCadastro;
    @BindView(R.id.lblVersion) TextView lblVersion;
    @BindView(R.id.loading) ProgressBar loading;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        try {
            this.getSupportActionBar().hide();

            context = this;

            initScreen();
        } catch (Exception ex) {
            Log.e(TAG, "onCreate: ", ex);
        }
    }

    @Override
    public void initScreen() {
        try {

            loading.setVisibility(View.GONE);

            lblVersion.setText(String.format("V %1$s", util.getInfoApp(context).versionName));

            btnLogin.setOnClickListener(v -> login());

        } catch (Exception ex) {
            Log.e(TAG, "initScreen: ", ex);
        }
    }

    @Override
    public void loadData() {}

    private void login() {
        try {

            new LoginTask(edtLogin.getText().toString(),edtSenha.getText().toString(),  () -> {
                startActivity(new Intent(this, MainActivity.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            }, this).execute();

        } catch (Exception ex) {
            Log.e(TAG, "login: ", ex);
        }
    }
}
