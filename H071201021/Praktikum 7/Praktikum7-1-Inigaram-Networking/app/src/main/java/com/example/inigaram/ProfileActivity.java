package com.example.inigaram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class ProfileActivity extends AppCompatActivity {
    ProgressBar progressBar;

    private ImageView profilePic;
    private TextView username,fullname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        progressBar = findViewById(R.id.progress_bar);
        profilePic = findViewById(R.id.profile_civ);
        username = findViewById(R.id.username_tv);
        fullname = findViewById(R.id.fullname_tv);
        progressBar.setVisibility(View.VISIBLE);

        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        progressBar.setVisibility(View.GONE);
                        profilePic.setVisibility(View.VISIBLE);
                        username.setVisibility(View.VISIBLE);
                        fullname.setVisibility(View.VISIBLE);
                    }
                });
            }
        }).start();

        Intent intent = getIntent();
        Post post = intent.getParcelableExtra("post");
        if (post.getProfilePicture() != null) {
            Glide.with(this)
                    .load(post.getProfilePicture())
                    .into(profilePic);
        }
        username.setText(post.getUsername());
        fullname.setText(post.getFullname());
    }
}