package com.example.whatsapp_ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfilePicture extends AppCompatActivity {
    private TextView tv_username;
    private ImageView civ_image;
    private ImageView back_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_picture);

        tv_username = findViewById(R.id.textViewUsername);
        civ_image = findViewById(R.id.imageViewUserPicture);
        back_button = findViewById(R.id.back_button);

        Intent terima = getIntent();
        String name = terima.getStringExtra("name");
        tv_username.setText(name);
        int drawableId = terima.getIntExtra("drawable_id", 0);

        civ_image.setImageResource(drawableId);

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // access the name variable of MyData using myData.getName()
                finish();
            }
        });
    }
}