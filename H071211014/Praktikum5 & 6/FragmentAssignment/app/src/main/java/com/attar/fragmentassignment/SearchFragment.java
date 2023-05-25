package com.attar.fragmentassignment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class SearchFragment extends Fragment {

    private static SearchFragment instance;

    public static SearchFragment getInstance(){
        if (instance == null){
            instance = new SearchFragment();
        }
        return instance;
    }

    private SearchAdapter adapter;

    private RecyclerView rvSearch;
    private ProgressBar progressBar;

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    @Override
    public void onViewCreated (@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvSearch = view.findViewById(R.id.rv_search);
        rvSearch.setLayoutManager(new LinearLayoutManager(getContext()));

        adapter = new SearchAdapter();
        rvSearch.setAdapter(adapter);

        progressBar = view.findViewById(R.id.progress_bar);

        TextInputEditText etSearch = view.findViewById(R.id.et_search);
        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged (CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged (CharSequence charSequence, int i, int i1, int i2) {
                searchUser(charSequence.toString());
            }

            @Override
            public void afterTextChanged (Editable editable) {

            }
        });
    }

    private void searchUser(String query) {
        showLoading(true);

        Executor executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());
        executor.execute(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            handler.post(() -> {
                if (TextUtils.isEmpty(query)){
                    adapter.setUsers(new ArrayList<>());
                    adapter.notifyDataSetChanged();
                } else {
                    ArrayList<User> searchedUsers = DataSource.getUsersByQueryName(query);
                    adapter.setUsers(searchedUsers);
                    adapter.notifyDataSetChanged();
                }
                showLoading(false);
            });
        });
    }

    private void showLoading(boolean isShow){
        if (isShow){
            progressBar.setVisibility(View.VISIBLE);
            rvSearch.setVisibility(View.INVISIBLE);
        } else {
            progressBar.setVisibility(View.INVISIBLE);
            rvSearch.setVisibility(View.VISIBLE);
        }
    }
}