package com.example.praktikum4_1;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ChatActivity extends AppCompatActivity {
    private TextView tv_nama;
    private ImageView imgPhoto, btn_back;
    private RecyclerView rvChat;
    private ArrayList<ChatMessage> list = new ArrayList<>();
    private LinearLayout header;
    String details = "";
    Data data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        tv_nama = findViewById(R.id.tv_name);
        imgPhoto = findViewById(R.id.iv_profile);
        header = findViewById(R.id.header);
        btn_back = findViewById(R.id.button_back);

        Intent intent = getIntent();
        if (intent != null) {
            data = intent.getParcelableExtra("DATA");
            details = data.getDetail();
            if (data != null) {
                tv_nama.setText(data.getName());
                Glide.with(this)
                        .load(data.getPhoto())
                        .apply(new RequestOptions().override(200, 200))
                        .into(imgPhoto);
            }
        }
        rvChat = findViewById(R.id.rv_message);

        list.addAll(ChatMessageData.getListChatMessage());


        list.add(new ChatMessage(details, 0,"10:50"));



        rvChat.setLayoutManager(new LinearLayoutManager(this));
        ChatAdapter chatsAdapter = new ChatAdapter(list);
        rvChat.setAdapter(chatsAdapter);

        header.setOnClickListener(view -> {
            Intent profile = new Intent(ChatActivity.this, ProfileActivity.class);
            profile.putExtra("DATA", data);
            try {
                startActivity(profile);
            } catch (ActivityNotFoundException e) {
                Log.e("TAG", "Error starting activity: " + e.getMessage());
            }
        });
        btn_back.setOnClickListener(view -> {
            Intent mainActivity = new Intent(ChatActivity.this, MainActivity.class);
            try {
                startActivity(mainActivity);
            } catch (ActivityNotFoundException e) {
                Log.e("TAG", "Error starting activity: " + e.getMessage());
            }
        });
    }
}

