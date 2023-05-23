package com.example.chattingapp;

public class ChatList {
    private String  Message, Time;
    public ChatList(String message, String time) {
        Message = message;
        Time = time;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }
}
