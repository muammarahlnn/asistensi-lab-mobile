package com.example.kuis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Score extends AppCompatActivity {
    ImageView Profil;
    TextView tvname, tvbestscore;
    Button btnplay;
    String Name;

    Photo photo;

    int bestScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        Profil = findViewById(R.id.foto);
        tvname = findViewById(R.id.name);
        tvbestscore = findViewById(R.id.best_score);
        btnplay = findViewById(R.id.play);

        Intent intent = getIntent();
        Name = intent.getStringExtra("FULL NAME");
        photo = intent.getParcelableExtra("PROFIL");
        tvname.setText(Name);
        Profil.setImageURI(photo.getFotoUri());

        // get best score
        bestScore = intent.getIntExtra("bestscore", 0);
        tvbestscore.setText(String.valueOf(bestScore));

        if (bestScore != 0){
            btnplay.setText("play again!");
        }

        btnplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toQuiz = new Intent(Score.this, Quiz.class);
                toQuiz.putExtra("FULL NAME", Name);
                toQuiz.putExtra("bestscore", bestScore);
                toQuiz.putExtra("PROFIL", photo);
                startActivity(toQuiz);
            }
        });


    }
}