package com.example.tugasrecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Parcelable;
import android.widget.ImageView;
import android.widget.TextView;

public class ShowProfile extends AppCompatActivity {
    private TextView profileName;
    private ImageView profileImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_profile);
        profileName = findViewById(R.id.profileName);
        profileImage = findViewById(R.id.imageView);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            profileName.setText(bundle.getString("name"));
            profileImage.setImageResource(bundle.getInt("image"));
        }

    }
}