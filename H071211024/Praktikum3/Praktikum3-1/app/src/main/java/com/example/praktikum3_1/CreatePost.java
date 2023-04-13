package com.example.praktikum3_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


public class CreatePost extends AppCompatActivity {

    String profilePic, fullName, username;
    ImageView postPicture, postPic;
    Button upload;
    EditText caption;
    int SELECT_POST_IMAGE_CODE = 1;
    Uri postUri;
    private final String EXTRA_POST_PICTURE = "EXTRA_POST_PICTURE";
    private final String EXTRA_CAPTION = "EXTRA_CAPTION";
    private final String EXTRA_PROFILE_PICTURE = "EXTRA_PROFILE_PICTURE";
    private final String EXTRA_FULLNAME = "EXTRA_FULLNAME";
    private final String EXTRA_USERNAME = "EXTRA_USERNAME";
    boolean imageSelected = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_post);

        upload = findViewById(R.id.upload);
        postPicture = findViewById(R.id.postPic);
        caption = findViewById(R.id.caption);
        profilePic = EXTRA_PROFILE_PICTURE;
        username = EXTRA_USERNAME;
        fullName = EXTRA_FULLNAME;

        Intent intent1 = getIntent();
        String profileUriString = intent1.getStringExtra(EXTRA_PROFILE_PICTURE);
        String username = intent1.getStringExtra(EXTRA_USERNAME);
        String fullName = intent1.getStringExtra(EXTRA_FULLNAME);
        Uri profile_picture = Uri.parse(profileUriString);

        postPicture.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(intent, SELECT_POST_IMAGE_CODE);
        });

        upload.setOnClickListener(v -> {
            if (imageSelected) {
                String full = fullName;
//                String user = username.getEditText().toString();
                String postCaption = caption.getText().toString();
                Intent intent = new Intent(this, Post.class);
                intent.putExtra(EXTRA_POST_PICTURE, postUri.toString());
                intent.putExtra(EXTRA_CAPTION, postCaption);
                intent.putExtra(EXTRA_PROFILE_PICTURE, profile_picture.toString());
                intent.putExtra(EXTRA_FULLNAME, full);
                intent.putExtra(EXTRA_USERNAME, username);
                startActivity(intent);
            } else {
                Toast.makeText(this, "Please Select a Picture", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (SELECT_POST_IMAGE_CODE == 1 && resultCode == RESULT_OK && data != null) {
            postUri = data.getData();
            postPicture.setImageURI(postUri);
            imageSelected = true;
        } else {
            Toast.makeText(this, "Failed to get Image", Toast.LENGTH_SHORT).show();
        }
    }
}