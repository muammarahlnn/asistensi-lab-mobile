package com.example.fragment1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    public ImageView btnAdd, btnProfile, btnHome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initiateViews();
        FragmentManager fragmentManager = getSupportFragmentManager();
        HomeFragment homeFragment = new HomeFragment();
        Fragment fragment =
                fragmentManager.findFragmentByTag(HomeFragment.class.getSimpleName());
            if(!(fragment instanceof HomeFragment)){
                fragmentManager.beginTransaction().add(R.id.frame_layout, homeFragment
                ,HomeFragment.class.getSimpleName()).commit();
            }

            btnAdd.setOnClickListener( v -> {
            PostFragment postFragment = new PostFragment();
            Fragment fragmentPost = fragmentManager.findFragmentByTag(PostFragment.class.getSimpleName());
            if(!(fragmentPost instanceof PostFragment)){
                fragmentManager.beginTransaction().replace(R.id.frame_layout, postFragment
                , PostFragment.class.getSimpleName()).commit();
            }
        });;
            btnProfile.setOnClickListener(v -> {
                ProfileFragment profileFragment = new ProfileFragment();
                Fragment fragmentProfile = fragmentManager.findFragmentByTag(ProfileFragment.class.getSimpleName());
                if(!(fragmentProfile instanceof ProfileFragment)){
                    fragmentManager.beginTransaction().replace(R.id.frame_layout, profileFragment
                    ,ProfileFragment.class.getSimpleName()).commit();
                }
            });
            btnHome.setOnClickListener(v -> {
                if(!(fragment instanceof HomeFragment)){
                    fragmentManager.beginTransaction().replace(R.id.frame_layout, homeFragment
                            ,HomeFragment.class.getSimpleName()).commit();
                }
            });
    }


    private void initiateViews(){
        btnAdd = findViewById(R.id.addBtn);
        btnProfile = findViewById(R.id.profileBtn);
        btnHome = findViewById(R.id.homeBtn);
    }
}