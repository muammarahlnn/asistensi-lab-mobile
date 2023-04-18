package com.example.recyclerview.messages;

import java.util.ArrayList;

public class DataIsiChat {
    public static ArrayList<IsiChat> fill = generateDummyIsiChat();

    private static ArrayList<IsiChat> generateDummyIsiChat() {
        ArrayList<IsiChat> fill = new ArrayList<>();
        fill.add(new IsiChat("ssss", "10.10"));
        fill.add(new IsiChat("ssss", "10.10"));
        fill.add(new IsiChat("ssss", "10.10"));
        fill.add(new IsiChat("p", "21.21"));
        return fill;
    }
}
