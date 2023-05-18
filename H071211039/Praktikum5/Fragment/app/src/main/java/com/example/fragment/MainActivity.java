package com.example.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;

    private ImageButton btnHome, btnUpload, btnProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnHome = findViewById(R.id.btnHomePage);
        btnUpload = findViewById(R.id.btnPost);
        btnProfile = findViewById(R.id.btnProfil);

        fragmentManager = getSupportFragmentManager();
        HomeFragment homeFragment = new HomeFragment();
        Fragment fragment =
                fragmentManager.findFragmentByTag(HomeFragment.class.getSimpleName());
        if (!(fragment instanceof HomeFragment)) {
            fragmentManager
                    .beginTransaction()
                    .add(R.id.frame_container, homeFragment, HomeFragment.class.getSimpleName())
                    .commit();
        }

        navigationListener();
    }

    private void navigationListener() {
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_container, new HomeFragment(), HomeFragment.class.getSimpleName())
                    .commit();
            }
        });
        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_container, new UploadFragment(), UploadFragment.class.getSimpleName())
                        .commit();
            }
        });
        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_container, new ProfileFragment(), ProfileFragment.class.getSimpleName())
                        .commit();
            }
        });
    }
}