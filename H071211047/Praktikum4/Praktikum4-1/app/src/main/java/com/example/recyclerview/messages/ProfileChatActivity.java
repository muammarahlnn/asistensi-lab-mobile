package com.example.recyclerview.messages;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.recyclerview.R;

public class ProfileChatActivity extends AppCompatActivity {

    public static final String EXTRA_CHATDATA = "extra_chatdata";
    TextView namaprofil;
    ImageView pp;
    ImageButton btnback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_chat);

        namaprofil = findViewById(R.id.namaprofil);
        pp = findViewById(R.id.pp);
        btnback = findViewById(R.id.btnback);
        ChatModel chat = getIntent().getParcelableExtra(EXTRA_CHATDATA);
//        String a = chat.getNama();
//        Log.e("test", a);
        namaprofil.setText(chat.getNama());
        Glide.with(ProfileChatActivity.this).load(chat.getFoto()).apply(new RequestOptions().override(350,350)).into(pp);

        btnback.setOnClickListener(view -> {
            finish();
        });
    }
}