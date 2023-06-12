package com.example.inigaram;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class ProfileFragment extends Fragment {
    private RecyclerView rvProfileGrid;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TabLayout tabLayout = view.findViewById(R.id.tab_layout);
        ViewPager2 viewPagerProfile = view.findViewById(R.id.view_pager_profile);
        ProfilePagerAdapter profilePagerAdapter = new ProfilePagerAdapter(requireActivity());
        viewPagerProfile.setAdapter(profilePagerAdapter);

        new TabLayoutMediator(tabLayout, viewPagerProfile, (tab, position) -> {
            switch (position) {
                case 0:
                    tab.setIcon(R.drawable.baseline_grid_on_24);
                    break;
                case 1:
                    tab.setIcon(R.drawable.baseline_video_library_24);
                    break;
                case 2:
                    tab.setIcon(R.drawable.baseline_account_box_24);
                    break;
            }
        }).attach();

        ImageView post_iv = view.findViewById(R.id.post_iv);
        post_iv.setOnClickListener(btn -> {
            PostFragment postFragment = new PostFragment();
            FragmentManager fragmentManager = getParentFragmentManager();
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_container, postFragment,
                            PostFragment.class.getSimpleName())
                    .addToBackStack(null)
                    .commit();
        });
    }
}