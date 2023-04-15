package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import de.hdodenhof.circleimageview.CircleImageView;

public class ActivitySecond extends AppCompatActivity {

    TextView edName1,bscore;

    CircleImageView uImage1;
    Button pButton;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        edName1 = findViewById(R.id.tUser);
        uImage1 = findViewById(R.id.profile_image1);
        pButton = findViewById(R.id.BPlay);
        bscore = findViewById(R.id.bscore1);

        String data1= getIntent().getStringExtra("Fname");
        Uri uri1 = getIntent().getParcelableExtra("image");
        edName1.setText(data1);
        uImage1.setImageURI(uri1);
        int bestScore = getIntent().getIntExtra("best_score", 0);
        bscore.setText("Best score: " + bestScore);
        pButton.setOnClickListener(view -> {
            String data11 = getIntent().getStringExtra("Fname");
            Uri uri11 = getIntent().getParcelableExtra("image");
            int bestScore1 = getIntent().getIntExtra("best_score", 0);
            Intent KeMain = new Intent(getApplicationContext(), MainActivity.class);
            KeMain.putExtra("Fname" , data11);
            KeMain.putExtra("best_score", bestScore1);
            KeMain.putExtra("image" , uri11);
            startActivity(KeMain);
        });


    }

}