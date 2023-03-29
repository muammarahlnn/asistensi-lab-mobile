package com.attar.tugas3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.attar.tugas3.databinding.ActivityPostactivityBinding;

public class PostActivity extends AppCompatActivity {

    public static final String EXTRA_USER = "extra_user";

    private ActivityPostactivityBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPostactivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        User user = getIntent().getParcelableExtra(EXTRA_USER);

        binding.ivFotomelingkar.setImageURI(user.getPhotoUri());
        binding.tvFullname.setText(user.getFullname());
        binding.tvUsername.setText(user.getUsername());
        binding.ivPost.setImageURI(user.getPost().getPhotoUri());
        binding.tvCaption.setText(user.getPost().getCaption());
    }
}