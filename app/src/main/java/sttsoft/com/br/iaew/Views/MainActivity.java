package sttsoft.com.br.iaew.Views;

import android.app.ActionBar;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.microsoft.signalr.HubConnection;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import butterknife.BindView;
import butterknife.ButterKnife;
import sttsoft.com.br.iaew.Domains.Connection.ConnectionFactory;
import sttsoft.com.br.iaew.Domains.Service.MessageService;
import sttsoft.com.br.iaew.Models.model.Usuario;
import sttsoft.com.br.iaew.R;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Main Ac";

    @BindView(R.id.lstContacts) RecyclerView lstContacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setTitle(Usuario.getInstance().getName());

       FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> {
            try {


            } catch (Exception ex) {
                System.out.println(ex);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.icSair) {
            try {
                Usuario.getInstance().logout(this);

                startActivity(new Intent(this, LoginActivity.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            } catch (Exception ex) {
                Log.e(TAG, "onOptionsItemSelected: ", ex);
            }
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent i = new Intent(this, MessageService.class);
        startService(i);
    }

}
