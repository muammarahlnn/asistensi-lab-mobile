package com.example.chattingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rvChats = findViewById(R.id.rv_chat);
        rvChats.setHasFixedSize(true);
        rvChats.setLayoutManager(new LinearLayoutManager(this));
        rvChats.addItemDecoration(
                new DividerItemDecoration(rvChats.getContext(),DividerItemDecoration.VERTICAL)
        );

        ChatAdapter adapter = new ChatAdapter(DataSource.chats);
        rvChats.setAdapter(adapter);



    }
}