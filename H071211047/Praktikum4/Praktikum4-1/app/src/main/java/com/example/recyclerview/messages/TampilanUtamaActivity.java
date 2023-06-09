package com.example.recyclerview.messages;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.recyclerview.R;

public class TampilanUtamaActivity extends AppCompatActivity {
    public static final String EXTRA_DATACHAT = "extra_datachat";
    private TextView nama;
    private ImageButton imgebtn;
    private ImageView foto;
    private RelativeLayout header;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampilan_utama);
        nama = findViewById(R.id.nama);
        imgebtn = findViewById(R.id.imgebtn);
        foto = findViewById(R.id.foto);
        header = findViewById(R.id.header);

        ChatModel chat = getIntent().getParcelableExtra(EXTRA_DATACHAT);

        nama.setText(chat.getNama());
        Glide.with(TampilanUtamaActivity.this).load(chat.getFoto()).apply(new RequestOptions().override(350,350)).into(foto);

        header.setOnClickListener(view -> {
            Intent intent = new Intent(TampilanUtamaActivity.this, ProfileActivity.class);
            intent.putExtra(com.example.recyclerview.messages.ProfileActivity.EXTRA_DATACHAT, chat);
            startActivity(intent);
        });
        imgebtn.setOnClickListener(view -> finish());

        RecyclerView isichat = findViewById(R.id.isichat);
        isichat.setHasFixedSize(true);
        isichat.setLayoutManager(new LinearLayoutManager(this));

        if (DataIsiChat.fill.size() == 4) {
            DataIsiChat.fill.add(new IsiChat(chat.getChat(), chat.getWaktu()));
        } else {
            DataIsiChat.fill.remove(DataIsiChat.fill.size()-1);
            DataIsiChat.fill.add(new IsiChat(chat.getChat(), chat.getWaktu()));
        }

        adapter adapter = new adapter(DataIsiChat.fill);
        isichat.setAdapter(adapter);
    }
}