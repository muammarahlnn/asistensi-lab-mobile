package com.example.praktikum4_1;

public class ChatMessage {
    private String message;
    private int sender;
    private String timeSent;

    public ChatMessage(String message, int sender, String timeSent) {
        this.message = message;
        this.sender = sender;
        this.timeSent = timeSent;
    }

    public ChatMessage() {

    }

    public String getMessage() {
        return message;
    }

    public int getSender() {
        return sender;
    }

    public String getTimeSent() {
        return timeSent;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public void setSender(int sender) {
        this.sender = sender;
    }

    public void setTimeSent(String timeSent) {
        this.timeSent = timeSent;
    }
}