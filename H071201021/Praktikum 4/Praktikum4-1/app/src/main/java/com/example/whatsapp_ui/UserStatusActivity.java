package com.example.whatsapp_ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserStatusActivity extends AppCompatActivity {
    private TextView username;
    private TextView userNumber;
    private TextView userStatus;
    private TextView userStatusDate;
    private CircleImageView user_image;
    private ImageView back_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_status);
        username = findViewById(R.id.username);
        userNumber = findViewById(R.id.userNumber);
        userStatus = findViewById(R.id.userStatus);
        userStatusDate = findViewById(R.id.userStatusDate);
        user_image = findViewById(R.id.user_image);
        back_button = findViewById(R.id.back_button);

        Intent terima = getIntent();
        String name = terima.getStringExtra("name");
        String noTelp = terima.getStringExtra("noTelp");
        String status = terima.getStringExtra("status");
        String statusDate = terima.getStringExtra("statusDate");
        int drawableId = terima.getIntExtra("drawable_id", 0);

        username.setText(name);
        userNumber.setText(noTelp);
        userStatus.setText(status);
        userStatusDate.setText(statusDate);
        user_image.setImageResource(drawableId);

        user_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // access the name variable of MyData using myData.getName()
                Intent kirim = new Intent(UserStatusActivity.this, ProfilePicture.class);

                kirim.putExtra("name", name);
                kirim.putExtra("drawable_id", drawableId);

                startActivity(kirim);
            }
        });

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // access the name variable of MyData using myData.getName()
                finish();
            }
        });
    }
}