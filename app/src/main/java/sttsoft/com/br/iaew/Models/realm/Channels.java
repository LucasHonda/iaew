package sttsoft.com.br.iaew.Models.realm;

import java.util.Date;

import io.realm.RealmObject;
import lombok.Data;

@Data
public class Channels extends RealmObject {
    private String id;
    private byte[] img;
    private String channelName;
    private String lastMsg;
    private Date lastAccess;
}
