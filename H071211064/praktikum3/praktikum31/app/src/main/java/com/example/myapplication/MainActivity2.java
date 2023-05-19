package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    Button upload;
    private static final int PICK_IMAGE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        }
        public void postPhoto(View view){
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/*");
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE);
        }
        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE && resultCode == RESULT_OK && data != null && data.getData() != null){
        Uri imageUri = data.getData();
        ImageView imagePost = findViewById(R.id.post_image);
        imagePost.setImageURI(imageUri);
        Profile profile = getIntent().getParcelableExtra("profile");
            EditText caption = findViewById(R.id.caption);
        upload = findViewById(R.id.upload);
        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String captionQuote = caption.getText().toString();
                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                Post post = new Post(captionQuote);
                intent.putExtra("post", post);
                intent.putExtra("profile", profile);
                intent.putExtra("imagePost", imageUri.toString());
                startActivity(intent);
            }
        });
        }
    }
}