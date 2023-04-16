package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
TextView fullNameText, userNameText, captionQuote;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Profile profile = getIntent().getParcelableExtra("profile");
        Post post = getIntent().getParcelableExtra("post");
        String imagePost = getIntent().getStringExtra("imagePost");
        fullNameText = findViewById(R.id.full_name);
        userNameText = findViewById(R.id.username);
        captionQuote = findViewById(R.id.caption);
        ImageView imageProfileView = findViewById(R.id.place_holder);
        ImageView imagePostView = findViewById(R.id.post_image);
        fullNameText.setText(profile.getFullName());
        userNameText.setText(profile.getUserName());
        captionQuote.setText(post.getCaption());
        imageProfileView.setImageURI(profile.getImageUri());
        imagePostView.setImageURI(Uri.parse(imagePost));

    }
}