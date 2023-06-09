package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.intent.databinding.ActivityMain2Binding;
import com.google.android.material.imageview.ShapeableImageView;

import java.io.IOException;

public class MainActivity2 extends AppCompatActivity {

    ShapeableImageView post;
    ImageView upfoto;
    Button btnpost;
    EditText caption;

    private static final int PICK_IMAGE = 1;
    Uri upfotoUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        post = findViewById(R.id.post);
        upfoto = findViewById(R.id.upfoto);
        btnpost = findViewById(R.id.btnpost);
        caption = findViewById(R.id.caption);

        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(gallery,1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE && resultCode == RESULT_OK) {
            upfotoUri = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), upfotoUri);
                post.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void upload(View view) {

        String capt = caption.getText().toString();
        Uri pp =  getIntent().getParcelableExtra("profil");
        String fName = getIntent().getStringExtra("fullname");
        String uName = getIntent().getStringExtra("username");

        if (upfotoUri == null) {
            Toast.makeText(this, "please select an image", Toast.LENGTH_SHORT).show();
        } else {
            Intent tes = new Intent(this, MainActivity3.class);
            tes.putExtra("caption", capt);
            tes.putExtra("post", upfotoUri);
            tes.putExtra("fullname", fName);
            tes.putExtra("username", uName);
            tes.putExtra("profil", pp);
            startActivity(tes);
        }
    }

}