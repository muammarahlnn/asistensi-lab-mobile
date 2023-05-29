package com.example.networking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity2 extends AppCompatActivity {
    private TextView tv_nama, tv_email;
    private ImageView iv_profil;
    private ProgressBar progressBar;
    private CardView cv;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tv_nama = findViewById(R.id.tv_nama);
        tv_email = findViewById(R.id.tv_email);
        iv_profil = findViewById(R.id.iv_profil);
        progressBar = findViewById(R.id.progressBar);
        cv = findViewById(R.id.cv);

        Intent intent = getIntent();
        String nama = intent.getStringExtra("nama");
        String email = intent.getStringExtra("email");
        String avatar = intent.getStringExtra("avatar");

        progressBar.setVisibility(View.VISIBLE);
        cv.setVisibility(View.GONE);

        Executor executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());

        executor.execute(()->{
            try {
                Thread.sleep(1000);

                handler.post(()->{
                    progressBar.setVisibility(View.GONE);
                    cv.setVisibility(View.VISIBLE);
                });
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        });

        tv_nama.setText(nama);
        tv_email.setText(email);
        Glide.with(this).load(avatar).into(iv_profil);
    }
}