package com.example.chattingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity4 extends AppCompatActivity {
    TextView tv_back, tv_name;
    ImageView iv_profil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        tv_back = findViewById(R.id.tv_back);
        tv_name = findViewById(R.id.tv_nama);
        iv_profil = findViewById(R.id.iv_profil);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String nohp = intent.getStringExtra("nohp");
        String status = intent.getStringExtra("status");
        String statusDate = intent.getStringExtra("statusDate");
        int profil = intent.getIntExtra("profil",0);

        tv_name.setText(name);
        iv_profil.setImageResource(profil);

        tv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}