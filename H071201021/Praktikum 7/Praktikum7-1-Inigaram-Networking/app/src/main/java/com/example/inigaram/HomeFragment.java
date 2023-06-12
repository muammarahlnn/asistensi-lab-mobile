package com.example.inigaram;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {
    ProgressBar progressBar;
    ImageView failed_iv;
    TextView failed_tv;


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
        failed_iv = view.findViewById(R.id.failed_iv);
        failed_tv = view.findViewById(R.id.failed_tv);


        progressBar = view.findViewById(R.id.progress_bar);

        rvPost.setLayoutManager(new LinearLayoutManager(getContext()));
        rvStory.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        // set adapter to rv
        PostAdapter postAdapter = new PostAdapter(DataSource.posts);
        StoryAdapter storyAdapter = new StoryAdapter(DataSource.posts);

        postAdapter.setClickListener(new PostAdapter.ClickListener() {
            @Override
            public void onProfileClicked(Post post) {
                Intent intent = new Intent(view.getContext(), ProfileActivity.class);
                intent.putExtra("post", post);
                view.getContext().startActivity(intent);
            }

            @Override
            public void onImageClicked(Post post) {
                Toast.makeText(getActivity(), "Home Post by : " + post.getFullname(), Toast.LENGTH_SHORT).show();
            }
        });

        storyAdapter.setClickListener(new StoryAdapter.ClickListener() {
            @Override
            public void onItemClicked(Post post) {
                Toast.makeText(getActivity(), "Home Story by : "+ post.getFullname(), Toast.LENGTH_SHORT).show();

            }
        });

        rvPost.setAdapter(postAdapter);
        rvStory.setAdapter(storyAdapter);

        // Fetch posts and update the adapters
        fetchPosts(postAdapter, storyAdapter);

        failed_iv.setOnClickListener(btn -> {
            fetchPosts(postAdapter, storyAdapter);
        });
    }

    private void fetchPosts(final PostAdapter postAdapter, final StoryAdapter storyAdapter) {
        progressBar.setVisibility(View.VISIBLE); // Show ProgressBar
        failed_iv.setVisibility(View.GONE);
        failed_tv.setVisibility(View.GONE);
        Call<DataResponse> client = ApiConfig.getApiService().getUsers("12");
        client.enqueue(new Callback<DataResponse>() {
            @Override
            public void onResponse(Call<DataResponse> call, Response<DataResponse> response) {
                progressBar.setVisibility(View.GONE); // Hide ProgressBar

                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        List<UserResponse> userResponse = response.body().getData();
                        DataSource.posts.clear();
                        for (UserResponse user : userResponse) {
                            Post post = new Post(user.getFirstName(), user.getEmail(), user.getAvatarUrl(), String.valueOf(user.getId()), user.getAvatarUrl());
                            DataSource.posts.add(post);
                        }
                        // Notify the adapters of the data change
                        postAdapter.notifyDataSetChanged();
                        storyAdapter.notifyDataSetChanged();
                    }
                } else {
                    if (response.body() != null) {
                        Log.e("DataSource", "onFailure: " + response.message());
                    }
                }
            }

            @Override
            public void onFailure(Call<DataResponse> call, Throwable t) {
                progressBar.setVisibility(View.GONE); // Hide ProgressBar
                failed_iv.setVisibility(View.VISIBLE);
                failed_tv.setVisibility(View.VISIBLE);
                Log.e("DataSource", "onFailure: " + t.getMessage());
            }
        });
    }


}