package com.example.praktikum4_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity4 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        Button backButton = findViewById(R.id.backButton);
        TextView userScore = findViewById(R.id.userScore);
        TextView userHighScore = findViewById(R.id.userHighScore);
        TextView textViewGGWP = findViewById(R.id.textViewGGWP);
        Intent i = getIntent();
        int userScoreInt = i.getIntExtra("userScore", 0);
        String currentHighScore = i.getStringExtra("currentHighScore");
        String stringUsername = i.getStringExtra("stringUsername");
        String profileImageUriString = i.getStringExtra("PROFILE_IMAGE_URI");

        String stringUserScore = String.valueOf(userScoreInt);
        if (userScoreInt > 200) {
            textViewGGWP.setText("Selamat " + stringUsername + " ente wibu terbaik sepanjang masa");
        }
        else {
            textViewGGWP.setText("Nice try " + stringUsername + " tingkatkan wibunya");
        }
        userScore.setText(stringUserScore);
        userHighScore.setText(currentHighScore);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity4.this, MainActivity2.class);
                intent.putExtra("stringUsername", stringUsername);
                intent.putExtra("userScore", stringUserScore);
                intent.putExtra("currentHighScore", currentHighScore);
                intent.putExtra("PROFILE_IMAGE_URI", profileImageUriString);
                startActivity(intent);
            }
        });
    }
}