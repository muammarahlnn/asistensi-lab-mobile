package com.example.parcelablequiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DisplayScore extends AppCompatActivity {
    private TextView scoreText, playScore;
    private Button backButton;
    private ImageView  imageProfileView;
    private User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_score);
        scoreText = findViewById(R.id.scoreText);
        playScore = findViewById(R.id.playScore);
        backButton = findViewById(R.id.backHome);
        imageProfileView = findViewById(R.id.place_holder);

        user = getIntent().getParcelableExtra("user");

        String playScoreGame = getIntent().getStringExtra("score");
        String finalScore = scoreText.getText().toString();
        String imageProfile = getIntent().getStringExtra("imageProfile");
        imageProfileView.setImageURI(android.net.Uri.parse(imageProfile));

        playScore.setText(playScoreGame);

        if(playScoreGame != null){
            int score = Integer.parseInt(playScoreGame);
            if(score > user.getScore()){
                user.setScore(score);
            }
            scoreText.setText(String.valueOf(user.getScore()));
        }

        backButton.setOnClickListener(v ->{
            Intent intent = new Intent(this, MainActivity2.class);
            intent.putExtra("user", user);
            intent.putExtra("score", finalScore);
            intent.putExtra("imageProfile", imageProfile);
            startActivity(intent);
        });
    }
}