package com.example.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class ProfileActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

//        fragmentManager = getSupportFragmentManager();
//        ProfileFragment profileFragment = new ProfileFragment();
//        Fragment fragment =
//                fragmentManager.findFragmentByTag(ProfileFragment.class.getSimpleName());
//        if (!(fragment instanceof ProfileFragment)) {
//            fragmentManager
//                    .beginTransaction()
//                    .add(R.id.frame_container, profileFragment, ProfileFragment.class.getSimpleName())
//                    .commit();
//        }
    }
}