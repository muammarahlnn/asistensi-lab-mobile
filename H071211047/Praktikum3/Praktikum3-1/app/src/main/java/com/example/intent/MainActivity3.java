package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.intent.databinding.ActivityMain2Binding;
import com.example.intent.databinding.ActivityMain3Binding;
import com.google.android.material.imageview.ShapeableImageView;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity3 extends AppCompatActivity {

    CircleImageView pp;
    TextView user, location, desc;
    ImageView gambar;

    Uri gambarUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        pp = findViewById(R.id.pp);
        user = findViewById(R.id.user);
        location = findViewById(R.id.location);
        desc = findViewById(R.id.desc);
        gambar = findViewById(R.id.gambar);

        String username = getIntent().getStringExtra("username");
        String lokasi = getIntent().getStringExtra("location");
        String capt = getIntent().getStringExtra("caption");
        Uri profil = getIntent().getParcelableExtra("profil");
        Uri gambarUri = getIntent().getParcelableExtra("gambar");

        user.setText(username);
        location.setText(lokasi);
        desc.setText(capt);
        pp.setImageURI(profil);
        gambar.setImageURI(gambarUri);
    }
}