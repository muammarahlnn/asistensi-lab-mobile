package com.example.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    private ImageButton homeButton, uploadButton, profileButton;
    private FrameLayout fragmentContainer;

    private HomeFragment homeFragment;
    private UploadFragment uploadFragment;
    private ProfileFragment profileFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentContainer = findViewById(R.id.fragment_container);
        homeButton = findViewById(R.id.bottom_navigation_home);
        uploadButton = findViewById(R.id.bottom_navigation_dashboard);
        profileButton = findViewById(R.id.bottom_navigation_notifications);

        // Set homeButton sebagai tombol aktif pertama
        homeButton.setSelected(true);

        homeFragment = new HomeFragment();
        uploadFragment = new UploadFragment();
        profileFragment = new ProfileFragment();

        // Tampilkan HomeFragment pada container saat pertama kali dibuka
        replaceFragment(homeFragment);

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Tampilkan HomeFragment pada container
                replaceFragment(homeFragment);
                homeButton.setSelected(true);
                uploadButton.setSelected(false);
                profileButton.setSelected(false);
            }
        });

        uploadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Tampilkan UploadFragment pada container
                replaceFragment(uploadFragment);
                homeButton.setSelected(false);
                uploadButton.setSelected(true);
                profileButton.setSelected(false);
            }
        });

        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Tampilkan ProfileFragment pada container
                replaceFragment(profileFragment);
                homeButton.setSelected(false);
                uploadButton.setSelected(false);
                profileButton.setSelected(true);
            }
        });
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();
    }
}
