package com.example.tugasrecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class ShowProfileHome extends AppCompatActivity {
    private TextView profileName;
    private ImageView profileImage;
    private ImageButton imageButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_profile_home);
        profileName = findViewById(R.id.profileName);
        profileImage = findViewById(R.id.imageView);
        imageButton = findViewById(R.id.backButton);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            profileName.setText(bundle.getString("name"));
            profileImage.setImageResource(bundle.getInt("image"));
        }
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShowProfileHome.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}