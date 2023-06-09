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
import androidx.recyclerview.widget.LinearLayoutManager;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class ProfileActivity extends AppCompatActivity {
    private ImageView iv_foto, btn_back;
    private TextView name,number,status,tanggal;
    private Data data;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        name = findViewById(R.id.tv_name);
        iv_foto = findViewById(R.id.iv_profile);
        number = findViewById(R.id.tv_number);
        status = findViewById(R.id.tv_status);
        tanggal = findViewById(R.id.tv_lastlogin);
        btn_back = findViewById(R.id.button_back);

        Intent intent = getIntent();
        if (intent != null) {
            data = intent.getParcelableExtra("DATA");
            if (data != null) {
                name.setText(data.getName());
                number.setText(data.getNumber());
                status.setText(data.getStatus());
                Glide.with(this)
                        .load(data.getPhoto())
                        .apply(new RequestOptions().override(200, 200))
                        .into(iv_foto);
            }
        }

        iv_foto.setOnClickListener(view -> {
            Intent picDetail = new Intent(ProfileActivity.this, ProfilepicActivity.class);
            picDetail.putExtra("DATA", data);
            try {
                startActivity(picDetail);
            } catch (ActivityNotFoundException e) {
                Log.e("TAG", "Error starting activity: " + e.getMessage());
            }
        });
        btn_back.setOnClickListener(view -> {
            Intent profile = new Intent(ProfileActivity.this, ChatActivity.class);
            profile.putExtra("DATA", data);
            try {
                startActivity(profile);
            } catch (ActivityNotFoundException e) {
                Log.e("TAG", "Error starting activity: " + e.getMessage());
            }
        });
    }
}
