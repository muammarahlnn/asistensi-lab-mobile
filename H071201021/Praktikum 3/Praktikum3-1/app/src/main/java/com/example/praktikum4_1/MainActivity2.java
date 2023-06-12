package com.example.praktikum4_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity2 extends AppCompatActivity {
    private static final int PICK_IMAGE_REQUEST = 1;
    String postImageUriString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button uploadButton = (Button)findViewById(R.id.uploadButton);
        EditText editTextUpload = findViewById(R.id.editTextUpload);
        ImageView postImage = findViewById(R.id.postImage);

        Intent i = getIntent();
        String stringFullname = i.getStringExtra("stringFullname");
        String stringUsername = i.getStringExtra("stringUsername");
        String profileImageUriString = i.getStringExtra("PROFILE_IMAGE_URI");
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        Toast toastWarning = Toast.makeText(context, "Please pick a post image first!", duration);


        postImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                intent.setType("image/*");
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
            }
        });

        uploadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uploadTextString = editTextUpload.getText().toString();
                if(!(postImageUriString == null)) {
                    Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                    intent.putExtra("uploadTextString", uploadTextString);
                    intent.putExtra("stringFullname", stringFullname);
                    intent.putExtra("stringUsername", stringUsername);
                    intent.putExtra("PROFILE_IMAGE_URI", profileImageUriString);
                    intent.putExtra("POST_IMAGE_URI", postImageUriString);
                    startActivity(intent);
                }
                else {
                    toastWarning.show();
                }
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri uri = data.getData();
            postImageUriString = uri.toString();

            ImageView postImage = findViewById(R.id.postImage);
            postImage.setImageURI(uri);
        }
    }

}