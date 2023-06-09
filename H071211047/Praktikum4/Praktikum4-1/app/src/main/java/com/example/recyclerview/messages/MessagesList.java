package com.example.recyclerview.messages;

public class MessagesList {

    private String name, lastMessage;
    private int unseenMessages;

    public MessagesList(String name, String lastMessage, int unseenMessages) {
        this.name = name;
        this.lastMessage = lastMessage;
        this.unseenMessages = unseenMessages;
    }

    public String getName() {
        return name;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public int getUnseenMessages() {
        return unseenMessages;
    }
}
