package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class Result extends AppCompatActivity {
    TextView scre,stat,bscore;
    Button reset;



    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        scre = findViewById(R.id.score);
        stat = findViewById(R.id.status);
        reset = findViewById(R.id.Rbutton);
        bscore = findViewById(R.id.bscore);

        Intent keEnd = getIntent();
        int Score = keEnd.getIntExtra("Score",0);
        String Stats= getIntent().getStringExtra("status");
        int bestScore = getIntent().getIntExtra("best_score", 0);
        bscore.setText("Best score: " + bestScore);

        scre.setText(String.valueOf(Score));
        stat.setText(Stats);

        reset.setOnClickListener(view -> {
            int bestScore1 = getIntent().getIntExtra("best_score", 0);
            String data1= getIntent().getStringExtra("Fname");
            Uri uri1 = getIntent().getParcelableExtra("image");
            Intent KeA = new Intent(getApplicationContext(), ActivitySecond.class);
            KeA.putExtra("best_score", bestScore1);
            KeA.putExtra("Fname" , data1);
            KeA.putExtra("image" ,uri1);
            startActivity(KeA);
        });

    }


}