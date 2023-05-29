package com.example.kuis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Detail_Score extends AppCompatActivity {
    TextView tvname, tvscore, tvbestscore;
    Button btnback;

    Photo photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_score);

        tvname = findViewById(R.id.name);
        tvscore = findViewById(R.id.score);
        tvbestscore = findViewById(R.id.best_score);
        btnback = findViewById(R.id.back);

        Intent intent = getIntent();
        String Name = intent.getStringExtra("FULL NAME");
        photo = intent.getParcelableExtra("PROFIL");
        int score = intent.getIntExtra("score", 0);
        int bestScore = intent.getIntExtra("bestscore", 0);

        tvname.setText(Name);
        tvscore.setText(String.valueOf(score));
        tvbestscore.setText(String.valueOf(bestScore));


        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Detail_Score.this, Score.class);
                intent.putExtra("bestscore", bestScore);
                intent.putExtra("PROFIL", photo);
                intent.putExtra("FULL NAME", Name);
                startActivity(intent);
                finish();
            }
        });
    }
}