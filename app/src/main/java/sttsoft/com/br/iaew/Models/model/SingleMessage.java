package sttsoft.com.br.iaew.Models.model;

import lombok.Data;

@Data
public class SingleMessage {
    private String To;
    private String From;
    private String Message;

    public SingleMessage(String to, String from, String message) {
        To = to;
        From = from;
        Message = message;
    }
}
