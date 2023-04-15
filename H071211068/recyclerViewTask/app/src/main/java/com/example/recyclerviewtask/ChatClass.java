package com.example.recyclerviewtask;


public class ChatClass {
    public static int LAYOUT_ONE =1;
    public static int LAYOUT_TWO =2;

    private final String message;
    private final int viewType;

    public ChatClass(String message, int viewType) {
        this.message = message;
        this.viewType = viewType;
    }




    public int getViewType() {
        return viewType;
    }

    public String getMessage() {
        return message;
    }
}
