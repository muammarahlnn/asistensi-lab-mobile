package com.example.backgroundthreadtask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Profil extends AppCompatActivity {

    private View progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        TextView namee = findViewById(R.id.namee);
        TextView userr = findViewById(R.id.userr);
        ImageView ppimg = findViewById(R.id.ppimg);
        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE); // Show the progress bar
        namee.setVisibility(View.GONE); // Hide the profile views initially
        userr.setVisibility(View.GONE);
        ppimg.setVisibility(View.GONE);
        Intent intent = getIntent();
        int image = intent.getIntExtra("GAMBAR", 0);
        String fullName1 = intent.getStringExtra("fullname");
        String nickName1 = intent.getStringExtra("username");

        ppimg.setImageResource(image);
        namee.setText(fullName1);
        userr.setText(nickName1);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Set the profile data
                ppimg.setImageResource(image);
                namee.setText(fullName1);
                userr.setText(nickName1);

                progressBar.setVisibility(View.GONE); // Hide the progress bar
                namee.setVisibility(View.VISIBLE); // Show the profile views
                userr.setVisibility(View.VISIBLE);
                ppimg.setVisibility(View.VISIBLE);
            }
        }, 2000); // Delay of 2000 milliseconds (2 seconds)
    }
    }
    