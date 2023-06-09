package com.attar.app_debug;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.attar.app_debug.databinding.ActivityScoreBinding;

public class ScoreActivity extends AppCompatActivity {

    private ActivityScoreBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityScoreBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        User user = getIntent().getParcelableExtra("user");

        binding.ivAva.setImageURI(user.getFotoUri());
        binding.tvName.setText(user.getName());
        binding.tvBestScore.setText("Best Score : " + user.getBestScore());
        binding.btnPlay.setOnClickListener(view -> {
            Intent toQuiz = new Intent(ScoreActivity.this, QuizActivity.class);
            toQuiz.putExtra("user", user);
            startActivity(toQuiz);
        });
    }
}