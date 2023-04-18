package com.example.recyclerview.messages;

import java.util.ArrayList;

public class ChatData {
    public static ArrayList<ChatModel> chat = generateDummyChatModel();

    private static ArrayList<ChatModel> generateDummyChatModel() {
        ArrayList<ChatModel> chat = new ArrayList<>();
        chat.add(new ChatModel("satu", "https://i.pinimg.com/564x/bb/93/7d/bb937d07baf2901499ba0c0816134756.jpg", "085211111101", "ayo", "10/10/10", "21:21", "P"));
        chat.add(new ChatModel("dua", "https://i.pinimg.com/564x/bb/93/7d/bb937d07baf2901499ba0c0816134756.jpg", "085211111101", "ayo", "10/10/10", "21:21", "P"));
        chat.add(new ChatModel("tiga", "https://i.pinimg.com/564x/bb/93/7d/bb937d07baf2901499ba0c0816134756.jpg", "085211111101", "ayo", "10/10/10", "21:21", "P"));
        chat.add(new ChatModel("empat", "https://i.pinimg.com/564x/bb/93/7d/bb937d07baf2901499ba0c0816134756.jpg", "085211111101", "ayo", "10/10/10", "21:21", "P"));
        chat.add(new ChatModel("lima", "https://i.pinimg.com/564x/bb/93/7d/bb937d07baf2901499ba0c0816134756.jpg", "085211111101", "ayo", "10/10/10", "21:21", "P"));
        chat.add(new ChatModel("enam", "https://i.pinimg.com/564x/bb/93/7d/bb937d07baf2901499ba0c0816134756.jpg", "085211111101", "ayo", "10/10/10", "21:21", "P"));
        chat.add(new ChatModel("tujuh", "https://i.pinimg.com/564x/bb/93/7d/bb937d07baf2901499ba0c0816134756.jpg", "085211111101", "ayo", "10/10/10", "21:21", "P"));
        chat.add(new ChatModel("delapan", "https://i.pinimg.com/564x/bb/93/7d/bb937d07baf2901499ba0c0816134756.jpg", "085211111101", "ayo", "10/10/10", "21:21", "P"));
        chat.add(new ChatModel("sembilan", "https://i.pinimg.com/564x/bb/93/7d/bb937d07baf2901499ba0c0816134756.jpg", "085211111101", "ayo", "10/10/10", "21:21", "P"));
        chat.add(new ChatModel("sepuluh", "https://i.pinimg.com/564x/bb/93/7d/bb937d07baf2901499ba0c0816134756.jpg", "085211111101", "ayo", "10/10/10", "21:21", "P"));
        return chat;
    }
}
