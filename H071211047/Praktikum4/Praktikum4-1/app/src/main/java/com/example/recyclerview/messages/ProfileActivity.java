package com.example.recyclerview.messages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.recyclerview.R;

public class ProfileActivity extends AppCompatActivity {

    public static final String EXTRA_DATACHAT = "extra_datachat";
    private ImageButton back;
    private TextView nama, tanggal, phone, status;
    private ImageView foto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        back = findViewById(R.id.btn_back);
        nama = findViewById(R.id.name);
        tanggal = findViewById(R.id.tanggal);
        phone = findViewById(R.id.phone);
        status = findViewById(R.id.status);
        foto = findViewById(R.id.iv_foto);

        ChatModel chat = getIntent().getParcelableExtra(EXTRA_DATACHAT);
        nama.setText(chat.getNama());
        Glide.with(ProfileActivity.this).load(chat.getFoto()).apply(new RequestOptions().override(350,350)).into(foto);
        phone.setText(chat.getNohp());
        tanggal.setText(chat.getTanggal());
        status.setText(chat.getBio());

        back.setOnClickListener(view -> {
            finish();
        });

        foto.setOnClickListener(view -> {
            Intent intent = new Intent(ProfileActivity.this, ProfileChatActivity.class);
            intent.putExtra(ProfileChatActivity.EXTRA_CHATDATA, chat);
            startActivity(intent);
        });
    }
}