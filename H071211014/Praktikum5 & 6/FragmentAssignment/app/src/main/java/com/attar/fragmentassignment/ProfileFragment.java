package com.attar.fragmentassignment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class ProfileFragment extends Fragment {

    private static ProfileFragment instance;

    public static ProfileFragment getInstance(){
        if (instance == null){
            instance = new ProfileFragment();
        }
        return instance;
    }

    private User user;

    public void setUser (User user) {
        this.user = user;
    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated (@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageView ivFotoProfile = view.findViewById(R.id.iv_fotoProfile);
        TextView tvfullName = view.findViewById(R.id.tv_fullName);
        TextView tvUsername = view.findViewById(R.id.tv_username);

        ivFotoProfile.setImageResource(user.getImageRes());
        tvfullName.setText(user.getFullname());
        tvUsername.setText(user.getUsername());
    }
}