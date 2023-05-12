package com.example.inigaram;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class HomeFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // setup rv
        RecyclerView rvPost = view.findViewById(R.id.rv_post);
        RecyclerView rvStory = view.findViewById(R.id.rv_story);

        rvPost.setLayoutManager(new LinearLayoutManager(getContext()));
        rvStory.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        // set adapter to rv
        PostAdapter postAdapter = new PostAdapter(DataSource.posts);
        StoryAdapter storyAdapter = new StoryAdapter(DataSource.posts);

        postAdapter.setClickListener(new PostAdapter.ClickListener() {
            @Override
            public void onItemClicked(Post post) {
                Toast.makeText(getActivity(), post.getFullname(), Toast.LENGTH_SHORT).show();

            }
        });

        storyAdapter.setClickListener(new StoryAdapter.ClickListener() {
            @Override
            public void onItemClicked(Post post) {
                Toast.makeText(getActivity(), "Story by : "+ post.getFullname(), Toast.LENGTH_SHORT).show();

            }
        });

        rvPost.setAdapter(postAdapter);
        rvStory.setAdapter(storyAdapter);

    }
}