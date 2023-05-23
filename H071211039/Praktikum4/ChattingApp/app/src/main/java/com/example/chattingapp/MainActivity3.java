package com.example.chattingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
    TextView tv_name, tv_NoHp, tv_status, tv_statusDate, tv_back;
    ImageView iv_profil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        tv_name = findViewById(R.id.tv_nama);
        tv_NoHp = findViewById(R.id.tv_nomor);
        tv_status = findViewById(R.id.tv_status);
        tv_statusDate = findViewById(R.id.tv_tanggal);
        iv_profil = findViewById(R.id.iv_profil);
        tv_back = findViewById(R.id.tv_back);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String nohp = intent.getStringExtra("nohp");
        String status = intent.getStringExtra("status");
        String statusDate = intent.getStringExtra("statusDate");
        int profil = intent.getIntExtra("profil",0);

        tv_name.setText(name);
        tv_NoHp.setText(nohp);
        tv_status.setText(status);
        tv_statusDate.setText(statusDate);
        iv_profil.setImageResource(profil);

        iv_profil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity3.this, MainActivity4.class);
                intent.putExtra("name", name);
                intent.putExtra("nohp", nohp);
                intent.putExtra("status", status);
                intent.putExtra("statusDate", statusDate);
                intent.putExtra("profil", profil);
                startActivity(intent);
            }
        });
        tv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity3.this, MainActivity2.class);
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