package com.example.praktikum3_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.imageview.ShapeableImageView;

public class Post extends AppCompatActivity {

    TextView username, fullname, caption;
    ShapeableImageView profilePic;
    ImageView postPic;
    private final String EXTRA_PROFILE_PICTURE = "EXTRA_PROFILE_PICTURE";
    private final String EXTRA_FULLNAME = "EXTRA_FULLNAME";
    private final String EXTRA_USERNAME = "EXTRA_USERNAME";
    private final String EXTRA_POST_PICTURE = "EXTRA_POST_PICTURE";
    private final String EXTRA_CAPTION = "EXTRA_CAPTION";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        profilePic = findViewById(R.id.profilePic);
        postPic = findViewById(R.id.postPic);
        username = findViewById(R.id.username);
        fullname = findViewById(R.id.fullname);
        caption = findViewById(R.id.caption);

        Intent intent = getIntent();
        String profileUriString = intent.getStringExtra(EXTRA_PROFILE_PICTURE);
        String postUriString = intent.getStringExtra(EXTRA_POST_PICTURE);
        String user_name = intent.getStringExtra(EXTRA_USERNAME);
        String full_name = intent.getStringExtra(EXTRA_FULLNAME);
        String post_caption = intent.getStringExtra(EXTRA_CAPTION);
        Uri profile_picture = Uri.parse(profileUriString);
        Uri post_picture = Uri.parse(postUriString);

        profilePic.setImageURI(profile_picture);
        postPic.setImageURI(post_picture);
        username.setText(user_name);
        fullname.setText(full_name);
        caption.setText(post_caption);
    }
}