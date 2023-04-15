package com.example.task4;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Objects;

public class PostActivity extends AppCompatActivity {

    EditText edCaption;
    Button btUpload;
    ImageView upImage;
    public static final String Key1 = "capt";

    private static final int RESULT_IMGUPL = 1;
    Uri selectedImage1;


    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        edCaption = findViewById(R.id.inputCaption);
        btUpload = findViewById(R.id.BUpload);
        upImage = findViewById(R.id.imageUpl);

        btUpload.setOnClickListener(view -> {
                if ((upImage.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.ic_launcher_background).getConstantState())){
                    Toast.makeText(PostActivity.this, "Upload Image First", Toast.LENGTH_SHORT).show();
                }else {
                    String user= getIntent().getStringExtra("Uname");
                    String name= getIntent().getStringExtra("Fname");
                    Uri selectedImage = getIntent().getParcelableExtra("image");
                    String caption = edCaption.getText().toString() ;
                    Intent Keline = new Intent(getApplicationContext(), Timeline.class);
                    Keline.putExtra(Key1 , caption);
                    Keline.putExtra("image", selectedImage);
                    Keline.putExtra("Uname", user);
                    Keline.putExtra("Fname", name);
                    Keline.putExtra("img" ,selectedImage1);
                    startActivity(Keline);
            }
        });

        upImage.setOnClickListener(view -> {
                Intent upIMG = new Intent(Intent.ACTION_PICK);
                upIMG.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(upIMG,RESULT_IMGUPL);
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_IMGUPL && resultCode == RESULT_OK){
            selectedImage1 = Objects.requireNonNull(data).getData();
            upImage.setImageURI(selectedImage1);
        }
    }
}