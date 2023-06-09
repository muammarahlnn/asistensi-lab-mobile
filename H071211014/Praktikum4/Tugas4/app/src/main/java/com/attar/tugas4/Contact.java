package com.attar.tugas4;

public class Contact {

    private String contact, chat, time;
    private int profilePicture;


    public Contact(String contact, String chat, String time, int profilePicture) {
        this.contact = contact;
        this.chat = chat;
        this.time = time;
        this.profilePicture = profilePicture;
    }


    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getChat() {
        return chat;
    }

    public void setChat(String chat) {
        this.chat = chat;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(int profilePicture) {
        this.profilePicture = profilePicture;
    }






}
