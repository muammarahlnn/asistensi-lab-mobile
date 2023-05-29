package com.example.prak_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class PostActivity extends AppCompatActivity {

    ImageView Profil, imgPost;
    TextView tvFullName, tvUsername, tvCaption;
    String fullname,username, caption;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        Profil = findViewById(R.id.profil);
        imgPost = findViewById(R.id.img_post);
        tvFullName = findViewById(R.id.full_name);
        tvUsername = findViewById(R.id.username);
        tvCaption = findViewById(R.id.caption);

        Intent intent = getIntent();
        fullname = intent.getStringExtra("FULL NAME");
        username = intent.getStringExtra("USERNAME");
        caption = intent.getStringExtra("caption");
        Photo photo = intent.getParcelableExtra("PROFIL");
        Photo post = intent.getParcelableExtra("POST");



        Profil.setImageURI(photo.getFotoUri());
        imgPost.setImageURI(post.getFotoUri());
        tvCaption.setText(caption);
        tvFullName.setText(fullname);
        tvUsername.setText(username);
    }
}