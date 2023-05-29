package com.example.prak_intent;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class UploadActivity extends AppCompatActivity {

    Button btnUpload;
    EditText inputText;
    boolean isEmpty = false;
    Uri uploadPicture;
    ImageView imgUpload;

    Photo photoProfile, photoPost;
    private ActivityResultLauncher<Intent> imageCaptureLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {

                    if(result.getResultCode() == RESULT_OK && result.getData() != null) {
                        Uri selectedPhoto = result.getData().getData();
                        imgUpload.setImageURI(selectedPhoto);
                        photoPost.setFotoUri(selectedPhoto);
                    }
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);

        btnUpload = findViewById(R.id.btn_upload);
        imgUpload = findViewById(R.id.img_upload);
        inputText = findViewById(R.id.input_text);

        Intent intent = getIntent();
        String fullname = intent.getStringExtra("FULL NAME");
        String username = intent.getStringExtra("USERNAME");
        photoProfile = intent.getParcelableExtra("PROFIL");
        photoPost = new Photo();


        imgUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentPicker = new Intent(Intent.ACTION_GET_CONTENT);
                intentPicker.setType("image/*");
                imageCaptureLauncher.launch(Intent.createChooser(intentPicker,"Choose a Photo"));
            }
        });

        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String caption = String.valueOf(inputText.getText());
                if (photoPost.getFotoUri() == null){
                    Toast.makeText(UploadActivity.this, "Please pick a post photoProfile first", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!isEmpty) {
                    Intent intent = new Intent(UploadActivity.this, PostActivity.class);
                    intent.putExtra("FULL NAME", fullname);
                    intent.putExtra("USERNAME", username);
                    intent.putExtra("caption", caption);
                    intent.putExtra("PROFIL", photoProfile);
                    intent.putExtra("POST", photoPost);
                    startActivity(intent);
                }
            }
        });

    }
}