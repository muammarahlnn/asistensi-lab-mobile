package com.example.fragtask;

import static androidx.fragment.app.FragmentTransaction.*;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();

        LinearLayout bottomNavigation = findViewById(R.id.bottom_navigation);
        ImageView homeButton = findViewById(R.id.home_button);
        ImageView postButton = findViewById(R.id.add_button);
        ImageView profileButton = findViewById(R.id.profile_button);

        // Add HomeFragment to the initial screen
        Fragment homeFragment = new HomeFragment();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.Nfrag, homeFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

        setClickListeners(homeButton, postButton, profileButton);
    }

    private void setClickListeners(ImageView homeButton, ImageView postButton, ImageView profileButton) {
        homeButton.setOnClickListener(v -> {
            Fragment fragment = fragmentManager.findFragmentByTag("HomeFragment");
            if (fragment == null) {
                fragment = new HomeFragment();
            }
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.Nfrag, fragment, "HomeFragment");
            transaction.commit();
        });

        postButton.setOnClickListener(v -> {
            Fragment fragment = fragmentManager.findFragmentByTag("PostFragment");
            if (fragment != null) {
//
                fragmentManager.popBackStackImmediate("PostFragment", FragmentManager.POP_BACK_STACK_INCLUSIVE);
            }
            fragment = new PostFragment();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.Nfrag, fragment, "PostFragment");
            transaction.addToBackStack(null);
            transaction.commit();
        });

        profileButton.setOnClickListener(v -> {
            Fragment fragment = fragmentManager.findFragmentByTag("ProfileFragment");
            if (fragment == null) {
                fragment = new ProfFragment();
            }
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.Nfrag, fragment, "ProfileFragment");
            transaction.addToBackStack(null);
            transaction.commit();
        });
    }

}