package com.example.praktikum4_1;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;


public class ProfilepicActivity extends AppCompatActivity {
    private ImageView iv_foto, btn_back;
    private TextView name;
    private Data data;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profilepic);

        name = findViewById(R.id.tv_name);
        iv_foto = findViewById(R.id.iv_profile);
        btn_back = findViewById(R.id.button_back);

        Intent intent = getIntent();
        if (intent != null) {
            data = intent.getParcelableExtra("DATA");
            if (data != null) {
                name.setText(data.getName());
                Glide.with(this)
                        .load(data.getPhoto())
                        .apply(new RequestOptions().override(200, 200))
                        .into(iv_foto);
            }
        }
        btn_back.setOnClickListener(view -> {
            Intent profile = new Intent(ProfilepicActivity.this, ProfileActivity.class);
            profile.putExtra("DATA", data);
            try {
                startActivity(profile);
            } catch (ActivityNotFoundException e) {
                Log.e("TAG", "Error starting activity: " + e.getMessage());
            }
        });
    }
}
