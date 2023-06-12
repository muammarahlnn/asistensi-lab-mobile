package com.example.inigaram;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
public class ProfilePagerAdapter extends FragmentStateAdapter {

    public ProfilePagerAdapter(FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new GridFragmentProfile();
            case 1:
                return new ReelsFragmentProfile();
            case 2:
                return new GridFragmentProfile();
            default:
                return null;
        }
    }

    @Override
    public int getItemCount() {
        return 3; // Number of sections
    }
}
