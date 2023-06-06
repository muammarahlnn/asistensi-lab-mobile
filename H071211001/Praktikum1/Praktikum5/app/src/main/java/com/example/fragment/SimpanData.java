package com.example.fragment;

import java.util.ArrayList;

public class SimpanData {
    public static ArrayList<ModelClass> DataPost = new ArrayList<>();

    public static ArrayList<ModelClass> getDataPost() {
        return DataPost;
    }

    public static void setDataPost(ModelClass modelClass) {
        DataPost.add(modelClass);
    }
}
