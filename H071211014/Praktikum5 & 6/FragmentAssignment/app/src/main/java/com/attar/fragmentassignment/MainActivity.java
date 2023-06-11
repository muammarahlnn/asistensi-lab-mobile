package com.attar.fragmentassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        fragmentManager
                .beginTransaction()
                .replace(R.id.frame_container,new HomeFragment(), HomeFragment.class.getSimpleName())
                .commit();

        navigationListener();

    }
    private void navigationListener(){
        ImageView navHome = findViewById(R.id.nav_home);
        ImageView navSearch = findViewById(R.id.nav_search);
        ImageView navAdd = findViewById(R.id.nav_add);
        ImageView navProfile = findViewById(R.id.nav_profile);


        navHome.setOnClickListener(view -> {
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_container, HomeFragment.getInstance(), HomeFragment.class.getSimpleName())
                    .commit();
        });
        navSearch.setOnClickListener(view -> {
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_container, SearchFragment.getInstance(), SearchFragment.class.getSimpleName())
                    .commit();
        });
        navAdd.setOnClickListener(view -> {
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_container,UploadFragment.getInstance(), UploadFragment.class.getSimpleName())
                    .commit();
        });

        navProfile.setOnClickListener(view -> {
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_container,ProfileFragment.getInstance(), ProfileFragment.class.getSimpleName())
                    .commit();
        });
    }
}