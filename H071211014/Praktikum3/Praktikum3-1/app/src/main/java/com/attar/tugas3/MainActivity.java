package com.attar.tugas3;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.attar.tugas3.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private User user;
    private ActivityMainBinding binding;

    private ActivityResultLauncher<Intent> launcherIntentPhotos = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result){
                    if (result != null) {
                        Uri imageUri = result.getData().getData();
                        user.setPhotoUri(imageUri);
                        binding.ivCircleimage.setImageURI(imageUri);
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
        binding.ivCircleimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentPicker = new Intent(Intent.ACTION_GET_CONTENT);
                intentPicker.setType("image/*");
                launcherIntentPhotos.launch(Intent.createChooser(intentPicker, "Choose a Photo"));
            }
        });
        binding.btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fullname = binding.fullname.getText().toString().trim();
                String username = binding.tvUsername.getText().toString().trim();
                user.setFullname(fullname);
                user.setUsername(username);
                Intent toUpload = new Intent(MainActivity.this, UploadActivity.class);
                toUpload.putExtra(UploadActivity.EXTRA_USER,user);
                startActivity(toUpload);
            }
        });
    }
}