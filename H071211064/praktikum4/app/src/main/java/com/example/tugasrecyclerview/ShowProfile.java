package com.example.tugasrecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class ShowProfile extends AppCompatActivity {
    private TextView profileName;
    private ImageView profileImage;
    private ImageButton imageButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_profile);
        profileName = findViewById(R.id.profileName);
        profileImage = findViewById(R.id.imageView);
        imageButton = findViewById(R.id.backButton);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            profileName.setText(bundle.getString("name"));
            profileImage.setImageResource(bundle.getInt("image"));
            String status = getIntent().getExtras().getString("status");
            String phoneNumber = getIntent().getExtras().getString("phoneNumber");
            String date = getIntent().getExtras().getString("date");
        }
          imageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(ShowProfile.this, Profile.class);
                    intent.putExtra("name", bundle.getString("name"));
                    intent.putExtra("image", bundle.getInt("image"));
                    intent.putExtra("status", bundle.getString("status"));
                    intent.putExtra("phoneNumber", bundle.getString("phoneNumber"));
                    intent.putExtra("date", bundle.getString("date"));
                    startActivity(intent);
                }
            });
    }
}