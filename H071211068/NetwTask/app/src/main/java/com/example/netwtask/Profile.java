package com.example.netwtask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import de.hdodenhof.circleimageview.CircleImageView;

public class Profile extends AppCompatActivity {
    private View progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        CircleImageView avatar = findViewById(R.id.profileImageView);
        TextView name = findViewById(R.id.name);
        TextView email = findViewById(R.id.email);
        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE); // Show the progress bar
        avatar.setVisibility(View.GONE); // Hide the profile views initially
        name.setVisibility(View.GONE);
        email.setVisibility(View.GONE);

        String avatarUrl = getIntent().getStringExtra("avatarUrl");
        String fullName = getIntent().getStringExtra("fullName");
        String userEmail = getIntent().getStringExtra("email");

        Glide.with(this)
                .load(avatarUrl)
                .into(avatar);

        new Handler().postDelayed(() -> {
            // Set the profile data
            name.setText(fullName);
            email.setText(userEmail);

            progressBar.setVisibility(View.GONE); // Hide the progress bar
            avatar.setVisibility(View.VISIBLE); // Show the profile views
            name.setVisibility(View.VISIBLE);
            email.setVisibility(View.VISIBLE);
        }, 2000); // Delay of 2000 milliseconds
    }
}
