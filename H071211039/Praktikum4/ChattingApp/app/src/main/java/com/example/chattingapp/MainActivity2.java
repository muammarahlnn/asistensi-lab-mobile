package com.example.chattingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity2 extends AppCompatActivity {
    LinearLayout toProfil;
    TextView tv_back, tv_nama;
    CircleImageView iv_profil;
    RecyclerView rv_roomchat;
    private ArrayList<ChatList> chatlist = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        rv_roomchat= findViewById(R.id.rv_roomchat);
        rv_roomchat.setHasFixedSize(true);
        rv_roomchat.setLayoutManager(new LinearLayoutManager(this));
        rv_roomchat.addItemDecoration(
                new DividerItemDecoration(rv_roomchat.getContext(),DividerItemDecoration.VERTICAL)
        );

        toProfil = findViewById(R.id.toProfil);
        tv_back = findViewById(R.id.tv_back);
        tv_nama = findViewById(R.id.tv_nama);
        iv_profil = findViewById(R.id.iv_profil);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String nohp = intent.getStringExtra("nohp");
        String status = intent.getStringExtra("status");
        String statusDate = intent.getStringExtra("statusDate");
        int profil = intent.getIntExtra("profil",0);
        String chat = intent.getStringExtra("chat");
        String time = intent.getStringExtra("time");

        tv_nama.setText(name);
        iv_profil.setImageResource(profil);
        chatlist.addAll(DataSource_ChatList.getChatList2());
        chatlist.add(new ChatList(chat,time));

        ChatListAdapter adapter = new ChatListAdapter(chatlist);
        rv_roomchat.setAdapter(adapter);

        tv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);
            }
        });

       toProfil.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
               intent.putExtra("name", name);
               intent.putExtra("nohp", nohp);
               intent.putExtra("status", status);
               intent.putExtra("statusDate", statusDate);
               intent.putExtra("profil", profil);
               startActivity(intent);
           }
       });

    }
}