package sttsoft.com.br.iaew.Domains.Channels;

import android.content.Context;
import android.util.Log;

import java.util.Date;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import sttsoft.com.br.iaew.Models.realm.Channels;
import sttsoft.com.br.iaew.Utils.util;

public class daoChannels {

    private static final String TAG = "dao Channel";

    private Realm realm;

    public daoChannels(Context context) {
        initializeRealm(context);
    }

    private void initializeRealm(Context context) {
        try {
            realm.init(context);

            RealmConfiguration.Builder realmBuilder = new RealmConfiguration.Builder();

            realmBuilder.directory(util.getDiretorioRealm(context));
            realmBuilder.name("iaew.realm");

            RealmConfiguration config = realmBuilder.build();
            Realm.setDefaultConfiguration(config);

            realm = Realm.getInstance(config);
        } catch (Exception ex) {
            Log.e(TAG, "initializeRealm: ", ex);
        }
    }

    public void insert(String id, byte[] img, String name, String lastMsg) {
        realm.executeTransaction(realm1 -> {

            Channels c = realm1.where(Channels.class)
                    .equalTo("id", id)
                    .findFirst();

            if (c == null) {
                Channels ch = realm1.createObject(Channels.class);
                ch.setId(id);
                ch.setImg(img);
                ch.setChannelName(name);
                ch.setLastMsg(lastMsg);
                ch.setLastAccess(new Date());
            }

        });
    }

    public List<Channels> getAll() {
        return realm.copyFromRealm(realm.where(Channels.class).findAll());
    }
}
