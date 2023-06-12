package com.example.inigaram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ImageView home_iv = findViewById(R.id.home_iv);
        ImageView search_iv = findViewById(R.id.search_iv);
        ImageView post_iv = findViewById(R.id.post_iv);
        CircleImageView profile_iv = findViewById(R.id.profile_iv);

        final int borderWidth = profile_iv.getBorderWidth();

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager
                .beginTransaction()
                .replace(R.id.frame_container, new HomeFragment(),
                        HomeFragment.class.getSimpleName())
                .addToBackStack(null)
                .commit();

        home_iv.setOnClickListener(btn -> {
            Drawable drawable = home_iv.getDrawable();
            drawable.setColorFilter(Color.GRAY, PorterDuff.Mode.SRC_IN);
            home_iv.setImageDrawable(drawable);
            // Wait for 200 milliseconds
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Remove the color filter after 200 milliseconds
                    drawable.clearColorFilter();
                    home_iv.setImageDrawable(drawable);
                }
            }, 200);
            HomeFragment homeFragment = new HomeFragment();
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_container, homeFragment,
                            HomeFragment.class.getSimpleName())
                    .addToBackStack(null)
                    .commit();
        });

        search_iv.setOnClickListener(btn -> {
            Drawable drawable = search_iv.getDrawable();
            drawable.setColorFilter(Color.GRAY, PorterDuff.Mode.SRC_IN);
            search_iv.setImageDrawable(drawable);
            // Wait for 200 milliseconds
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Remove the color filter after 200 milliseconds
                    drawable.clearColorFilter();
                    search_iv.setImageDrawable(drawable);
                }
            }, 200);
            SearchFragment searchFragment = new SearchFragment();
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_container, searchFragment,
                            SearchFragment.class.getSimpleName())
                    .addToBackStack(null)
                    .commit();

        });

        post_iv.setOnClickListener(btn -> {
            Drawable drawable = post_iv.getDrawable();
            drawable.setColorFilter(Color.GRAY, PorterDuff.Mode.SRC_IN);
            post_iv.setImageDrawable(drawable);
//            Wait for 200 milliseconds
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Remove the color filter after 200 milliseconds
                    drawable.clearColorFilter();
                    post_iv.setImageDrawable(drawable);
                }
            }, 200);

            PostFragment postFragment = new PostFragment();
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_container, postFragment,
                            PostFragment.class.getSimpleName())
                    .addToBackStack(null)
                    .commit();

        });

        profile_iv.setOnClickListener(btn -> {
            profile_iv.setBorderWidth(borderWidth * 2);
            profile_iv.setBorderColor(Color.GRAY);
            // Wait for 200 milliseconds
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    profile_iv.setBorderWidth(borderWidth);
                    profile_iv.setBorderColor(Color.BLACK);
                }
            }, 200);
            ProfileFragment profileFragment = new ProfileFragment();
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_container, profileFragment,
                            SearchFragment.class.getSimpleName())
                    .addToBackStack(null)
                    .commit();
        });
    }

}
