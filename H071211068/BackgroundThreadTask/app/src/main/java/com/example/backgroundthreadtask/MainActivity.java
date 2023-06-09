package com.example.backgroundthreadtask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView navHome, navAdd, navProfile, navSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navAdd = findViewById(R.id.add_button);
        navHome = findViewById(R.id.home_button);
        navProfile = findViewById(R.id.profile_button);
        navSearch = findViewById(R.id.search_button);

        FragmentManager fragmentManager = getSupportFragmentManager();
        HomeFragment homeFragment = new HomeFragment();
        Fragment fragment = fragmentManager.findFragmentByTag(HomeFragment.class.getSimpleName());
        if (!(fragment instanceof HomeFragment)) {
            fragmentManager.beginTransaction().add(R.id.container, homeFragment,
                    HomeFragment.class.getSimpleName()).commit();
        }

        navHome.setOnClickListener( v -> switchFragment(new HomeFragment()) );
        navAdd.setOnClickListener( v -> switchFragment(new PostFragment()));
        navProfile.setOnClickListener( v -> switchFragment(new ProfileFragment()));
        navSearch.setOnClickListener( v -> switchFragment(new SearchFragment()));
    }

    private void switchFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        if(fragment instanceof HomeFragment){
            transaction.replace(R.id.container, fragment, HomeFragment.class.getSimpleName()).commit();
        } else {
            transaction.replace(R.id.container, fragment, HomeFragment.class.getSimpleName()).addToBackStack(null).commit();
        }

    }
}