package com.example.backgroundthreadfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.shimmer.ShimmerFrameLayout;

public class PhotoProfileActivity extends AppCompatActivity {

    ShimmerFrameLayout shimmerFrameLayout;
    ImageView profile;
    TextView username,nickname;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_profile);

        ModelDummy dummys = getIntent().getParcelableExtra("data");
        profile = findViewById(R.id.profile_img);
        nickname = findViewById(R.id.profile_nick);
        username = findViewById(R.id.profile_username);

        shimmerFrameLayout = findViewById(R.id.shimmer_view);
        shimmerFrameLayout.startShimmerAnimation();

        Handler handler = new Handler();
        handler.postDelayed(() -> {
            shimmerFrameLayout.stopShimmerAnimation();
            shimmerFrameLayout.setVisibility(View.VISIBLE);

            profile.setImageURI(dummys.getProfile());
            nickname.setText(dummys.getNickname());
            username.setText(dummys.getUsername());
            profile.setBackgroundResource(android.R.color.transparent);
            nickname.setBackgroundResource(android.R.color.transparent);
            username.setBackgroundResource(android.R.color.transparent);
        }, 5000);

    }
}