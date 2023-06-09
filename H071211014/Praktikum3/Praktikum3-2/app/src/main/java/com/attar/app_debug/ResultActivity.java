package com.attar.app_debug;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.attar.app_debug.databinding.ActivityResultBinding;
import com.google.android.material.color.utilities.Score;

public class ResultActivity extends AppCompatActivity {

    private ActivityResultBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityResultBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        User user = getIntent().getParcelableExtra("user");
        binding.tvYourScore.setText(String.valueOf(user.getCurrentScore()));
        binding.tvBestScore.setText(String.valueOf(user.getBestScore()));
        binding.btnBackToHome.setOnClickListener(view -> {
            Intent toScore = new Intent(ResultActivity.this, ScoreActivity.class);
            toScore.putExtra("user", user);
            startActivity(toScore);
            finishAffinity();
        });
    }
}