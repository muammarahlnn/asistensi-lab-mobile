package com.example.praktikum4_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        TextView uploadText = findViewById(R.id.uploadText);
        TextView textFullname = findViewById(R.id.textFullname);
        TextView textUsername = findViewById(R.id.textUsername);
        ImageView postImage = findViewById(R.id.postImage);
        CircleImageView profileImage = findViewById(R.id.profileImage);


        Intent i = getIntent();
        String uploadTextString = i.getStringExtra("uploadTextString");
        String stringFullname = i.getStringExtra("stringFullname");
        String stringUsername = i.getStringExtra("stringUsername");
        String profileImageUriString = i.getStringExtra("PROFILE_IMAGE_URI");
        String postImageUriString = i.getStringExtra("POST_IMAGE_URI");
        Uri profileImageUri = Uri.parse(profileImageUriString);
        Uri postImageUri = Uri.parse(postImageUriString);

        Log.d("Main Activity3", uploadTextString);
        uploadText.setText(uploadTextString);
        textFullname.setText(stringFullname);
        textUsername.setText(stringUsername);

        postImage.setImageURI(postImageUri);
        profileImage.setImageURI(profileImageUri);

    }
}