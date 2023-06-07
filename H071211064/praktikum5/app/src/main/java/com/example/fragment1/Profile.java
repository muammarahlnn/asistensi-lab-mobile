package com.example.fragment1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_profile);

        FragmentManager fragmentManager = getSupportFragmentManager();
        ProfileFragment homeFragment = new ProfileFragment();
        Fragment fragment =
                fragmentManager.findFragmentByTag(ProfileFragment.class.getSimpleName());
        if(!(fragment instanceof ProfileFragment)){
            fragmentManager.beginTransaction().add(R.id.frame_layout, homeFragment
                    ,ProfileFragment.class.getSimpleName()).commit();
        }

    }
}