package com.attar.fragmentassignment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class HomeFragment extends Fragment {

    private static HomeFragment instance;

    public static HomeFragment getInstance(){
        if (instance == null){
            instance = new HomeFragment();
        }
        return instance;
    }

    private PostAdapter postAdapter;
    private UploadFragment.UploadPostListener uploadPostListener = user -> {
        DataSource.addUser(user);
    };

    public UploadFragment.UploadPostListener getUploadPostListener(){
        return uploadPostListener;
    }

    private RecyclerView rvPost;

    private TextView tvAlert;

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated (@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvPost = view.findViewById(R.id.rv_post);

        rvPost.setLayoutManager(new LinearLayoutManager(getContext()));

        postAdapter = new PostAdapter();
        postAdapter.setUsers(DataSource.users);
        rvPost.setAdapter(postAdapter);
    }
}