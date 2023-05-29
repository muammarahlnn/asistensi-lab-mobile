package com.example.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProfileActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;
    private ImageView ivProfile;
    private TextView tvusername, tvfullname;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        ivProfile = findViewById(R.id.iv_profile);
        tvusername = findViewById(R.id.tvusername);
        tvfullname = findViewById(R.id.tvfullname);
        progressBar = findViewById(R.id.pgbar);

        Home home = getIntent().getParcelableExtra("home");


        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                progressBar.setVisibility(View.VISIBLE);

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            tvusername.setText(home.getUsername());
                            tvfullname.setText(home.getFullName());
                            ivProfile.setImageResource(home.getProfile());
                            progressBar.setVisibility(View.GONE);
                        }
                    });


            }
        });



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