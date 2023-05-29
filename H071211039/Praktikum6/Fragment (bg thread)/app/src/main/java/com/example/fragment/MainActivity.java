package com.example.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;

    private ImageButton btnHome, btnUpload, btnProfile, btnSearch;
    private TextView tvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnHome = findViewById(R.id.btnHomePage);
        btnUpload = findViewById(R.id.btnPost);
        btnProfile = findViewById(R.id.btnProfil);
        btnSearch = findViewById(R.id.btnSearch);
        tvTitle = findViewById(R.id.tvTitle);


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
                tvTitle.setText("Home");
                fragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_container, new HomeFragment(), HomeFragment.class.getSimpleName())
                    .commit();
            }
        });
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvTitle.setText("Search");
                fragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_container, new SearchFragment(), SearchFragment.class.getSimpleName())
                        .commit();
            }
        });
        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvTitle.setText("Upload");
                fragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_container, new UploadFragment(), UploadFragment.class.getSimpleName())
                        .commit();
            }
        });
        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                String name = "/isty"
//                Home home = new Home();
//                home.setFullName("isty Hamdayani");
//                home.setUsername("Iniiisty");
//                home.setProfile(R.drawable.foto1);
                tvTitle.setText("Profile");

                fragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_container, new ProfileFragment(), ProfileFragment.class.getSimpleName())
                        .commit();
            }
        });
    }
}