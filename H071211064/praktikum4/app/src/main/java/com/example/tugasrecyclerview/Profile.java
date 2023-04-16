package com.example.tugasrecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Profile extends AppCompatActivity {
    private ImageView imageView;
    private ImageButton backButton;
    private TextView profileName, profileStatus, profilePhoneNumber, profileDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        imageView = findViewById(R.id.imageView);
        profileName = findViewById(R.id.profileName);
        profileStatus = findViewById(R.id.statusProfile);
        profilePhoneNumber = findViewById(R.id.phoneNumber);
        profileDate = findViewById(R.id.dateProfile);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            imageView.setImageResource(bundle.getInt("image"));
            profileName.setText(bundle.getString("name"));
            profileStatus.setText(bundle.getString("status"));
            profilePhoneNumber.setText(bundle.getString("phoneNumber"));
            profileDate.setText(bundle.getString("date"));
        }
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Profile.this, ShowProfile.class);
                intent.putExtra("image", bundle.getInt("image"));
                intent.putExtra("name", bundle.getString("name"));
                intent.putExtra("status", bundle.getString("status"));
                intent.putExtra("phoneNumber", bundle.getString("phoneNumber"));
                intent.putExtra("date", bundle.getString("date"));
                startActivity(intent);
            }
        });
        backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Profile.this, ChatDetail.class);
                intent.putExtra("image", bundle.getInt("image"));
                intent.putExtra("name", bundle.getString("name"));
                intent.putExtra("status", bundle.getString("status"));
                intent.putExtra("phoneNumber", bundle.getString("phoneNumber"));
                intent.putExtra("date", bundle.getString("date"));
                startActivity(intent);
            }
        });
    }
}