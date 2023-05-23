package com.example.chattingapp;

import java.util.ArrayList;
import java.util.Arrays;
public class DataSource_ChatList {
    public static ArrayList<ChatList> chatlist = new ArrayList<>(
            Arrays.asList(
                    new ChatList("In publishing and graphic design, Lorem ipsum is a placeholder text commonly used to demonstrate the visual form of a document or a typeface without relying on meaningful content. ","20.20"),
                    new ChatList("Lorem ipsum may be used as a placeholder before final copy is available.","20.20"),
                    new ChatList("Lorem ipsum is a placeholder text commonly used to demonstrate the visual form of a document or a typeface without relying on meaningful content.","20.20"),
                    new ChatList("document or a typeface without relying on meaningful content.","20.20"),
                    new ChatList("Lorem ipsum may be used as a placeholder before final copy is available.","20.20"),
                    new ChatList("Capekkk tugasnya gk habis habis.","20.20"),
                    new ChatList("apayaaa","20.20"),
                    new ChatList("gtwww dehhh.","20.20")
            )
    );
    static ArrayList<ChatList> getChatList2() {
        ArrayList<ChatList> cl = chatlist;
        return cl;
    }
}
