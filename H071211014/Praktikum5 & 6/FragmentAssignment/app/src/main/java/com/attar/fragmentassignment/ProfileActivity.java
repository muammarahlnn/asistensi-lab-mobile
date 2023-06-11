package com.attar.fragmentassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        User user = getIntent().getParcelableExtra("user");

        FragmentManager fragmentManager = getSupportFragmentManager();
        ProfileFragment profileFragment = new ProfileFragment();
        profileFragment.setUser(user);
        fragmentManager.beginTransaction().replace(R.id.fragment_container, profileFragment).commit();
    }
}