package com.example.praktikum3_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Outline;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button applyName;
    EditText username;
    ImageView profilePicture;
    private final String EXTRA_PROFILE_PICTURE = "EXTRA_PROFILE_PICTURE";
    private final String EXTRA_USERNAME = "EXTRA_USERNAME";
    private final String EXTRA_SCORE = "EXTRA_SCORE";
    private final String EXTRA_HIGHSCORE = "EXTRA_HIGHSCORE";
    int SELECT_PROFILE_IMAGE_CODE = 1;
    Uri profileUri;
    boolean imageSelected = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        applyName = findViewById(R.id.applyName);
        username = findViewById(R.id.username);
        profilePicture = findViewById(R.id.profilePic);

        profilePicture.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(intent, SELECT_PROFILE_IMAGE_CODE);
        });

        applyName.setOnClickListener(view -> {
            if (imageSelected) {
                String nama = username.getText().toString();
                Intent intent = new Intent(MainActivity.this, Score.class);
                intent.putExtra(EXTRA_USERNAME, nama);
                intent.putExtra(EXTRA_PROFILE_PICTURE, profileUri.toString());
                intent.putExtra(EXTRA_SCORE, "0");
                intent.putExtra(EXTRA_HIGHSCORE, "0");
                startActivity(intent);
            } else {
                Toast.makeText(this, "Please Select The Picture", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (SELECT_PROFILE_IMAGE_CODE == 1 && resultCode == RESULT_OK && data != null) {
            profileUri = data.getData();
            profilePicture.setImageURI(profileUri);
            imageSelected = true;
        } else {
            Toast.makeText(this, "Failed to get Image", Toast.LENGTH_SHORT).show();
        }
    }
}