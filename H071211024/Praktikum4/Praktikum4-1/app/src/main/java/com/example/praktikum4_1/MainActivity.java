package com.example.praktikum4_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvChat;
    private ArrayList<Data> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvChat = findViewById(R.id.rv_chat);

        list.addAll(ChatAppData.getListData());

        rvChat.setLayoutManager(new LinearLayoutManager(this));
        ListAppChatAdapter listAppChatAdapter = new ListAppChatAdapter(list);
        rvChat.setAdapter(listAppChatAdapter);
    }
}