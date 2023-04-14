package com.example.praktikum4_1;

import java.util.ArrayList;

public class ChatMessageData {
    private static String message[] = {
            "Hello",
            "Hi",
            "Yo",
            "How are you",
            "you good?",
            "test",
            "Are you there?",
            "hello?",
    };
    private static int sender[] = {
            0,1,1,0,1,0,1,0,0,0
    };
    private static String timeSent[] = {
            "10:20",
            "10:22",
            "10:23",
            "10:25",
            "10:27",
            "10:29",
            "10:30",
            "10:32",
            "10:32",
            "10:32",
    };
    static ArrayList<ChatMessage> getListChatMessage(){
        ArrayList<ChatMessage> list = new ArrayList<>();
        for (int i = 0; i < message.length; i++){
            ChatMessage Chats = new ChatMessage();
            Chats.setMessage(message[i]);
            Chats.setSender(sender[i]);
            Chats.setTimeSent(timeSent[i]);
            list.add(Chats);
        }
        return list;
    }
}
