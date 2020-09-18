package sttsoft.com.br.iaew.Views;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import sttsoft.com.br.iaew.Models.model.Usuario;
import sttsoft.com.br.iaew.R;

public class SplashActivity extends AppCompatActivity {

    @BindView(R.id.ivLogo) ImageView ivLogo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
    }

    @Override
    protected void onStart() {
        super.onStart();

        Usuario.getInstance().getUser(this);

        new Handler().postDelayed(() -> {

            Intent i;

            if (Usuario.getInstance().isLogged())
                i = new Intent(this, MainActivity.class);
            else
                i = new Intent(this, LoginActivity.class);

            if (i != null) {
                startActivity(i);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                this.finish();
            }

        }, 1000);
    }
}
