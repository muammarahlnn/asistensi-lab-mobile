package com.example.recyclerviewtask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class chatBox extends AppCompatActivity {

    CircleImageView profile;
    TextView user;
    ImageButton view1;
    RecyclerView recyclerView;
    chatAdapter chatAdapter;
    ArrayList<ChatClass> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_box);

        profile = findViewById(R.id.profPics);
        user = findViewById(R.id.userr);
        view1 = findViewById(R.id.view);
        ImageButton back = findViewById(R.id.back);
        int pic = getIntent().getIntExtra("gambar", 0);
        String namaU = getIntent().getStringExtra("nama");
        String msg = getIntent().getStringExtra("chat");

        profile.setImageResource(pic);
        user.setText(namaU);

        recyclerView = findViewById(R.id.rv_parent);
        list = new ArrayList<>();

        list.add(new ChatClass("p", ChatClass.LAYOUT_ONE));
        list.add(new ChatClass("oi", ChatClass.LAYOUT_TWO));
        list.add(new ChatClass("oi", ChatClass.LAYOUT_ONE));
        list.add(new ChatClass("p", ChatClass.LAYOUT_TWO));
        list.add(new ChatClass("Adkh", ChatClass.LAYOUT_ONE));
        list.add(new ChatClass("apatuh", ChatClass.LAYOUT_TWO));
        list.add(new ChatClass("Mabar", ChatClass.LAYOUT_ONE));
        list.add(new ChatClass("Gasskan", ChatClass.LAYOUT_TWO));
        list.add(new ChatClass("okoklh", ChatClass.LAYOUT_ONE));
        list.add(new ChatClass("login", ChatClass.LAYOUT_TWO));
        list.add(new ChatClass("duluan", ChatClass.LAYOUT_ONE));
        list.add(new ChatClass("skuy", ChatClass.LAYOUT_TWO));
        list.add(new ChatClass("kelamaan coy gw nyari wanpis dulu yah", ChatClass.LAYOUT_ONE));
        list.add(new ChatClass("yaudah sini", ChatClass.LAYOUT_TWO));
        list.add(new ChatClass("yaudah", ChatClass.LAYOUT_ONE));
        list.add(new ChatClass("skuy", ChatClass.LAYOUT_TWO));
        list.add(new ChatClass(msg, ChatClass.LAYOUT_TWO));

        chatAdapter = new chatAdapter(list,chatBox.this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(chatAdapter);
        chatAdapter.notifyDataSetChanged();


        view1.setOnClickListener(view -> {
            int pic1 = getIntent().getIntExtra("gambar", 0);
            String namaU1 = getIntent().getStringExtra("nama");
            Intent intent = new Intent(chatBox.this, chatProfile.class);
            intent.putExtra("gambar1", pic1);
            intent.putExtra("nama1", namaU1);
            startActivity(intent);
        });

        back.setOnClickListener(view -> {
            Intent intent = new Intent(chatBox.this, MainActivity.class);
            startActivity(intent);
        });
    }
}