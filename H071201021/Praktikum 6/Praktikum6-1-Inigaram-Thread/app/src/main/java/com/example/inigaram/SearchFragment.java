package com.example.inigaram;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.SearchView;

import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;

public class SearchFragment extends Fragment {
    private RecyclerView rvSearch;
    private SearchView search_bar;
    private ProgressBar progressBar;
    ArrayList<Post> posts = DataSource.posts;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false);

    }

    private void performSearch(String query) {
        if (getActivity() != null) {
            ArrayList<Post> results = new ArrayList<Post>();
            //if (!query.isEmpty()) { // Check if the query is not empty
                for (int i = 0; i < posts.size(); i++) {
                    if (posts.get(i).getFullname().toLowerCase().contains(query.toLowerCase())) {
                        results.add(posts.get(i));
                    }
                }
            //}

            SearchAdapter adapter = new SearchAdapter(results);
            adapter.setOnItemClickCallBack(new SearchAdapter.OnItemClickCallBack() {
                @Override
                public void onItemClicked(Post post) {
                    Intent intent = new Intent(getContext(), ProfileActivity.class);
                    intent.putExtra("post", post);
                    getContext().startActivity(intent);
                }
            });
            rvSearch.setAdapter(adapter);
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvSearch = view.findViewById(R.id.rv_search);
        search_bar = view.findViewById(R.id.search_bar);
        progressBar =  view.findViewById(R.id.progress_bar);
        rvSearch.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        // set adapter to rv
        SearchAdapter searchAdapter = new SearchAdapter(DataSource.posts);
        rvSearch.setAdapter(searchAdapter);

        searchAdapter.setOnItemClickCallBack(new SearchAdapter.OnItemClickCallBack() {
            @Override
            public void onItemClicked(Post post) {
                Intent intent = new Intent(getContext(), ProfileActivity.class);
                intent.putExtra("post", post);
                getContext().startActivity(intent);
            }
        });

        search_bar.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                progressBar.setVisibility(View.VISIBLE);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        Handler handler = new Handler(Looper.getMainLooper());

                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                progressBar.setVisibility(View.GONE);
                                performSearch(query);
                            }
                        });
                    }
                }).start();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                progressBar.setVisibility(View.VISIBLE);

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        Handler handler = new Handler(Looper.getMainLooper());

                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                progressBar.setVisibility(View.GONE);

                                performSearch(newText);
                            }
                        });
                    }
                }).start();
                return true;
            }

        });

    }
}