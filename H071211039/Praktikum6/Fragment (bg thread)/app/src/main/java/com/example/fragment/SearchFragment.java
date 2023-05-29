package com.example.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class SearchFragment extends Fragment {

    private ProgressBar progressbar;
    private RecyclerView rvSearch;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        progressbar = view.findViewById(R.id.loading);
        rvSearch = view.findViewById(R.id.rvSearch);


        EditText etSearch = view.findViewById(R.id.et_search);
        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                searching(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
    private void searching(String query) {

        // show loading
        progressbar.setVisibility(View.VISIBLE);
        rvSearch.setVisibility(View.GONE);

        if (query.isEmpty()) {
            rvSearch.setAdapter(new SearchAdapter(new ArrayList<>()));

            // hide loading
            progressbar.setVisibility(View.GONE);
            rvSearch.setVisibility(View.VISIBLE);
            return;
        }

        Executor executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());
        executor.execute(new Runnable() {
            @Override
            public void run() {
                progressbar.setVisibility(View.VISIBLE);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                ArrayList<Home> searchedUser = DataSource.getHomesByQueryName(query);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        // adapter.setHomes(searchedUser);
                        rvSearch.setLayoutManager(new LinearLayoutManager(getActivity()));

                        // rvSearch.setAdapter(adapter);
                        rvSearch.setAdapter(new SearchAdapter(searchedUser));

                        // hide loading
                         progressbar.setVisibility(View.GONE);
                         rvSearch.setVisibility(View.VISIBLE);
                    }
                });
            }
        });
    }
}