package sttsoft.com.br.iaew.Models.model;

import java.util.Date;

import lombok.Data;

@Data
public class Channel {
    private byte[] img;
    private String channel;
    private String lastMsg;
    private Date lastAccess;
}
