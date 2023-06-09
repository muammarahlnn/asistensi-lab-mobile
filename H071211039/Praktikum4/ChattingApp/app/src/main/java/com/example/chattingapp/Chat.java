package com.example.chattingapp;

public class Chat {
    private String Name, Chat, Time, NoHP, Status, StatusDate;
    private int Image;

    public Chat(String name, String chat, String time, String nohp, String status, String statusdate, int image ) {
        Name = name;
        Chat = chat;
        Time = time;
        NoHP = nohp;
        Status = status;
        StatusDate = statusdate;
        Image = image;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getChat() {
        return Chat;
    }

    public void setChat(String chat) {
        Chat = chat;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getNoHP() {
        return NoHP;
    }

    public void setNoHP(String noHP) {
        NoHP = noHP;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getStatusDate() {
        return StatusDate;
    }

    public void setStatusDate(String statusDate) {
        StatusDate = statusDate;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }


}
