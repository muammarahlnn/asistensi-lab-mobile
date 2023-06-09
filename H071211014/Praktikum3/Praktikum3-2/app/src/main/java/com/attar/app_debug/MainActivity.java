package com.attar.app_debug;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.attar.app_debug.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private User user;

    private ActivityResultLauncher<Intent> launcherIntentPhotos = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result){
                    if (result != null) {
                        Uri imageUri = result.getData().getData();
                        user.setFotoUri(imageUri);
                        binding.ivAva.setImageURI(imageUri);
                    }
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        user = new User();
        binding.ivAva.setOnClickListener(view -> {
            Intent intentPicker = new Intent(Intent.ACTION_GET_CONTENT);
            intentPicker.setType("image/*");
            launcherIntentPhotos.launch(Intent.createChooser(intentPicker, "Choose a Photo"));
        });
        binding.btnApply.setOnClickListener(view -> {
            String name = binding.etName.getText().toString();
            user.setName(name);

            Intent toScore = new Intent(MainActivity.this, ScoreActivity.class);
            toScore.putExtra("user", user);
            startActivity(toScore);
        });
    }
    }