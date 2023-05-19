package com.example.task4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class Timeline extends AppCompatActivity {

    ImageView tlImage;
    TextView Tuser,Tname,Tcapt;
    CircleImageView ppImg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);

        tlImage = findViewById(R.id.imageContent);
        ppImg = findViewById(R.id.profile_img);
        Tuser = findViewById(R.id.userr);
        Tname = findViewById(R.id.namee);
        Tcapt = findViewById(R.id.captiontxt);

        Intent keline = getIntent();
        String data= keline.getStringExtra("Uname");
        String data1= keline.getStringExtra("Fname");
        Uri uri = keline.getParcelableExtra("img");
        Uri uri1 = keline.getParcelableExtra("image");
        String putCapt = keline.getStringExtra(PostActivity.Key1);
        Tuser.setText(data);
        Tname.setText(data1);
        Tcapt.setText(putCapt);
        tlImage.setImageURI(uri);
        ppImg.setImageURI(uri1);
    }
}