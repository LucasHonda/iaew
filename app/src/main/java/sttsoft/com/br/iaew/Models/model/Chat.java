package sttsoft.com.br.iaew.Models.model;

import java.util.ArrayList;

import lombok.Data;

@Data
public class Chat {
    private Channel channel;
    private ArrayList<Message> messages;
}
