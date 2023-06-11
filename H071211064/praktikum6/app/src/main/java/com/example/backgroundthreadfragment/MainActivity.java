package com.example.backgroundthreadfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    ImageView buttonAdd, button_person, button_home, button_search;

        private ArrayList<ModelDummy> dataDummies =new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); buttonAdd = findViewById(R.id.btn_add);
        button_person = findViewById(R.id.btn_person);
        button_home = findViewById(R.id.btn_home);
        button_search = findViewById(R.id.btn_search);

        setDataDummy();
        DataDummy.dataDummy = dataDummies;
        for (int i = 0; i < DataDummy.dataDummy.size(); i++) {
            Log.d("datadumi", DataDummy.dataDummy.get(i).getNickname());
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        HomeFragment homeFragment = new HomeFragment();
        AddFragment addFragment = new AddFragment();
        ProfileFragment profileFragment = new ProfileFragment();
        SearchFragment searchFragment = new SearchFragment();
        Fragment fragment1 = fragmentManager.findFragmentByTag(HomeFragment.class.getSimpleName());
        Fragment fragment2 = fragmentManager.findFragmentByTag(AddFragment.class.getSimpleName());
        Fragment fragment3 = fragmentManager.findFragmentByTag(ProfileFragment.class.getSimpleName());
        Fragment fragment4 = fragmentManager.findFragmentByTag(ProfileFragment.class.getSimpleName());

        if (!(fragment1 instanceof HomeFragment)) {
            fragmentManager
                    .beginTransaction()
                    .add(R.id.frame_layout,homeFragment,
                            HomeFragment.class.getSimpleName())
                    .commit();
        }

        button_home.setOnClickListener(v -> {
            if (!(fragment1 instanceof HomeFragment)) {
                fragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layout,homeFragment,
                                HomeFragment.class.getSimpleName())
                        .commit();
            }
        });

        buttonAdd.setOnClickListener(v -> {
            if (!(fragment2 instanceof AddFragment)) {
                fragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layout,addFragment,
                                AddFragment.class.getSimpleName())
                        .commit();
            }

        });

        button_person.setOnClickListener(v -> {
            if (!(fragment3 instanceof ProfileFragment)) {
                fragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layout,profileFragment,
                                ProfileFragment.class.getSimpleName())
                        .commit();
            }
        });

        button_search.setOnClickListener(v -> {
            if (!(fragment4 instanceof SearchFragment)) {
                fragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layout,searchFragment,
                                SearchFragment.class.getSimpleName())
                        .commit();
            }
        });
    }

    private void setDataDummy() {
        dataDummies.add(new ModelDummy( Uri.parse("android.resource://com.example.backgroundthreadfragment/drawable/marquis"),"Marquis De Gramont",
                "The High Table", Uri.parse("android.resource://com.example.backgroundthreadfragment/drawable/sacrecoeur"),"I am the High Table"));
        dataDummies.add(new ModelDummy( Uri.parse("android.resource://com.example.backgroundthreadfragment/drawable/caine"),"Caine",
                "The High Table's Assasin", Uri.parse("android.resource://com.example.backgroundthreadfragment/drawable/blindman"),"Blind Man"));
    }
}