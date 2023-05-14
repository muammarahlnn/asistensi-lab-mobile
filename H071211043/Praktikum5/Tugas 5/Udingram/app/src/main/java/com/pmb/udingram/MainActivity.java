package com.pmb.udingram;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentTransaction;

import com.pmb.udingram.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    int focusedColor, notFocusedColor;
    String selectedMenu = "0";
    Animation fadeInAnimation;
    HomeFragment homeFragment = new HomeFragment();
    AddPostFragment addPostFragment = new AddPostFragment();
    ProfileFragment profileFragment = new ProfileFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        focusedColor = ContextCompat.getColor(this, R.color.focused);
        notFocusedColor = ContextCompat.getColor(this, R.color.notFocused);
        fadeInAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in_animation);
        changeFragment(selectedMenu);
        binding.home.setOnClickListener(v -> {
            if (!selectedMenu.equals("0")){
                selectedMenu = "0";
                homeFragment.setArguments(null);
                changeFragment(selectedMenu);
            }
        });

        binding.post.setOnClickListener(v -> {
            if (!selectedMenu.equals("1")){
                selectedMenu = "1";

                changeFragment(selectedMenu);
            }
        });

        binding.profile.setOnClickListener(v -> {
            if(!selectedMenu.equals("2")){
                selectedMenu = "2";

                changeFragment(selectedMenu);
            }
        });
    }

    void changeFragment(String selectedMenu){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (selectedMenu.equals("0")){
            transaction.replace(R.id.fragmentContainer, homeFragment);
            binding.homeImg.setColorFilter(focusedColor);
            binding.homeImg.startAnimation(fadeInAnimation);

            binding.postImg.setColorFilter(notFocusedColor);
            binding.profileImg.setColorFilter(notFocusedColor);

        } else if (selectedMenu.equals("1")) {
            transaction.replace(R.id.fragmentContainer, addPostFragment);
            binding.postImg.setColorFilter(focusedColor);
            binding.postImg.startAnimation(fadeInAnimation);

            binding.homeImg.setColorFilter(notFocusedColor);
            binding.profileImg.setColorFilter(notFocusedColor);

        } else{
            transaction.replace(R.id.fragmentContainer, profileFragment);
            binding.profileImg.setColorFilter(focusedColor);
            binding.profileImg.startAnimation(fadeInAnimation);

            binding.homeImg.setColorFilter(notFocusedColor);
            binding.postImg.setColorFilter(notFocusedColor);
        }
        transaction.setReorderingAllowed(false);
        transaction.commit();
    }
}