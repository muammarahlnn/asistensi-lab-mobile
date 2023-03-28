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

import com.attar.tugas3.databinding.ActivityUploadBinding;

public class UploadActivity extends AppCompatActivity {
    public static final String EXTRA_USER = "extra_user";

    private ActivityUploadBinding binding;
    private User user;
    private Post post;

    private ActivityResultLauncher<Intent> launcherIntentPhotos = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result){
                    if (result != null) {
                        Uri imageUri = result.getData().getData();
                        post.setPhotoUri(imageUri);
                        binding.imageView.setImageURI(imageUri);
                    }
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUploadBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        user = getIntent().getParcelableExtra(EXTRA_USER);
        post = new Post();
        binding.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentPicker = new Intent(Intent.ACTION_GET_CONTENT);
                intentPicker.setType("image/*");
                launcherIntentPhotos.launch(Intent.createChooser(intentPicker, "Choose a Photo"));
            }
        });
        binding.btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String caption = binding.etCaption.getText().toString().trim();
                post.setCaption(caption);

                user.setPost(post);
                Intent toPost = new Intent(UploadActivity.this, PostActivity.class);
                toPost.putExtra(PostActivity.EXTRA_USER,user);
                startActivity(toPost);
            }
        });
    }
}