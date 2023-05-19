package com.example.tugasrecyclerview;

public class ChatModel {
    private String name;
    private String message;
    private String time;

    private String phoneNumber;

    private String status;
    private String date;
    private int image;

    public ChatModel(String name, String message, String time, String date, String status, String phoneNumber, int image) {
        this.name = name;
        this.message = message;
        this.time = time;
        this.image = image;
        this.date = date;
        this.status = status;
        this.phoneNumber = phoneNumber;

    }
    public String getName(){ return name;}
    public int getImage(){return image;}
    public String getMessage(){return message;}
    public String getTime(){return time;}
    public String getDate(){return date;}
    public String getStatus(){return status;}
    public String getPhoneNumber(){return phoneNumber;}


}
