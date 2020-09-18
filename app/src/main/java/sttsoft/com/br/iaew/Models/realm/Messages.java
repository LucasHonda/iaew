package sttsoft.com.br.iaew.Models.realm;

import java.util.Date;

import io.realm.RealmObject;
import lombok.Data;

@Data
public class Messages extends RealmObject {
    private Channels channel;
    private String text;
    //private int tipo;
    private String to;
    private String from;
    private Date data;
}
