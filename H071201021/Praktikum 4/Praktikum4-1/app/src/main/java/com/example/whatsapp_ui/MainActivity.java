package com.example.whatsapp_ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import androidx.fragment.app.Fragment;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager2 viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.viewpager);

        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new fragment_community());
        fragmentList.add(new fragment_chats());
        fragmentList.add(new fragment_status());
        fragmentList.add(new fragment_calls());

        MyPagerAdapter adapter = new MyPagerAdapter(this, fragmentList);

        viewPager.setAdapter(adapter);

        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabLayout, viewPager, true, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(TabLayout.Tab tab, int position) {
                switch (position) {
                    case 0:
                        tab.setIcon(R.drawable.baseline_people_24);
                        break;
                    case 1:
                        tab.setText("Chats");
                        break;
                    case 2:
                        tab.setText("Status");
                        break;
                    case 3:
                        tab.setText("Calls");
                        break;
                }
            }
        });

        tabLayoutMediator.attach();
    }
}