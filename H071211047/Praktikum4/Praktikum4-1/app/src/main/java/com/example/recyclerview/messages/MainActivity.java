package com.example.recyclerview.messages;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.recyclerview.R;
import com.example.recyclerview.messages.ChatData;
import com.example.recyclerview.messages.MessagesAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView messageRecycler = findViewById(R.id.messageRecycler);
        messageRecycler.setHasFixedSize(true);
        messageRecycler.setLayoutManager(new LinearLayoutManager(this));
        MessagesAdapter message = new MessagesAdapter(ChatData.chat);
        messageRecycler.setAdapter(message);
    }
}