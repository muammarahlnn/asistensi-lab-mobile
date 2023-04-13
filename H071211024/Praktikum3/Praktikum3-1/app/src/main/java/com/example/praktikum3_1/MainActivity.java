package com.example.praktikum3_1;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.textfield.TextInputLayout;

import java.io.IOException;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {

    EditText fullName, username;
    ImageView profilePicture;
    int SELECT_PROFILE_IMAGE_CODE = 1;
    Uri profileUri;
    private final String EXTRA_PROFILE_PICTURE = "EXTRA_PROFILE_PICTURE";
    private final String EXTRA_FULLNAME = "EXTRA_FULLNAME";
    private final String EXTRA_USERNAME = "EXTRA_USERNAME";
    boolean imageSelected = false;
    boolean filled = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fullName = findViewById(R.id.fullName);
        username = findViewById(R.id.username);
        Button submit = findViewById(R.id.submit);
        profilePicture = findViewById(R.id.profilePic);

        profilePicture.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(intent, SELECT_PROFILE_IMAGE_CODE);
        });

        submit.setOnClickListener(v -> {
            checkEmpty();
            if (imageSelected && filled) {
                String full = fullName.getText().toString();
                String user = username.getText().toString();
                Intent intent = new Intent(MainActivity.this, CreatePost.class);
                intent.putExtra(EXTRA_PROFILE_PICTURE, profileUri.toString());
                intent.putExtra(EXTRA_FULLNAME, full);
                intent.putExtra(EXTRA_USERNAME, user);
                startActivity(intent);
            } else {
                Toast.makeText(this, "Pastikan semua data telah terisi", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (SELECT_PROFILE_IMAGE_CODE == 1 && resultCode == RESULT_OK && data != null) {
            profileUri = data.getData();
            profilePicture.setImageURI(profileUri);
            imageSelected = true;
        } else {
            Toast.makeText(this, "Failed to get Image", Toast.LENGTH_SHORT).show();
        }
    }

    private void checkEmpty() {
        String full = fullName.getText().toString();
        String user = username.getText().toString();
        if(full.isEmpty()) {
            fullName.setError("Tidak Boleh Kosong");
            return;
        }
        if(user.isEmpty()) {
            username.setError("Tidak Boleh Kosong");
            return;
        }
        filled = true;
    }
}