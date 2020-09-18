package sttsoft.com.br.iaew.Models.model;

import java.util.Date;

import lombok.Data;

@Data
public class Message {
    private String message;
    private String from;
    private String to;
    //private int tipo;
    private String date;
}
