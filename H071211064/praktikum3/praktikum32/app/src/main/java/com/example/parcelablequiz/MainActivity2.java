package com.example.parcelablequiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
private TextView name, scoreText;
private User user;
private String imageProfile;
private Button playButton;
ImageView imageProfileView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        name = findViewById(R.id.name);
        imageProfileView = findViewById(R.id.place_holder);
        scoreText = findViewById(R.id.scoreText);
        user = getIntent().getParcelableExtra("user");
        playButton = findViewById(R.id.start_quiz);


        String imageProfile = getIntent().getStringExtra("imageProfile");
        String getBestScore = getIntent().getStringExtra("score");
        if(getBestScore != null){
            int bestScore = Integer.parseInt(getBestScore);
            playButton.setText("Play Again!");
            if(bestScore > user.getScore()){
                user.setScore(bestScore);
            }
            scoreText.setText(String.valueOf(user.getScore()));
        }
        name.setText(user.getName());
        imageProfileView.setImageURI(Uri.parse(imageProfile));

        playButton.setOnClickListener(v ->{
            Intent intent = new Intent(this, quizactivity.class);
            intent.putExtra("user", user);
            intent.putExtra("imageProfile", imageProfile);
            startActivity(intent);
            finish();
        });
    }

}