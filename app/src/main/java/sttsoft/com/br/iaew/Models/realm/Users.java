package sttsoft.com.br.iaew.Models.realm;

import io.realm.RealmObject;
import lombok.Data;

@Data
public class Users extends RealmObject {
    private String id;
    private String nome;
}
