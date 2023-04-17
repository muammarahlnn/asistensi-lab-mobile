package com.example.praktikum4_2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import de.hdodenhof.circleimageview.CircleImageView;
public class MainActivity2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button playButton = findViewById(R.id.playButton);
        TextView editTextUsername = findViewById(R.id.textViewUsername);
        CircleImageView profileImage = findViewById(R.id.profile_image);
        TextView editTextBestScore = findViewById(R.id.bestScore);

        Intent i = getIntent();
        String currentHighScore = i.getStringExtra("currentHighScore");
        editTextBestScore.setText("Best Score : " + currentHighScore);
        if (!currentHighScore.equals("0")) {
            playButton.setText("Play Again?");
        }
        String stringUsername = i.getStringExtra("stringUsername");
        editTextUsername.setText(stringUsername);
        String profileImageUriString = i.getStringExtra("PROFILE_IMAGE_URI");
        if (profileImageUriString != null) {
            Uri profileImageUri = Uri.parse(profileImageUriString);
            profileImage.setImageURI(profileImageUri);
        }

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                intent.putExtra("stringUsername", stringUsername);
                intent.putExtra("currentHighScore", currentHighScore);
                intent.putExtra("PROFILE_IMAGE_URI", profileImageUriString);
                startActivity(intent);
            }
        });
    }
}

