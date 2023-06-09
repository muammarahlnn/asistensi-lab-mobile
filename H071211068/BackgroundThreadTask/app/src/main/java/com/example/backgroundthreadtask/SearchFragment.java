package com.example.backgroundthreadtask;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.example.backgroundthreadtask.data.model.User;

import java.util.ArrayList;
import java.util.List;


public class SearchFragment extends Fragment {
    SearchView searchView;
    ProgressBar progressBar;
    RecyclerView recyclerView;

    private Handler handler;
    private boolean isProgressBarVisible = false;

    List<User>filterUsers;
    SearchAdapter searchAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {




        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false);
    }
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        Handler handler = new Handler();
        filterUsers = new ArrayList<>();
        searchView = view.findViewById(R.id.searchView);
        progressBar = view.findViewById(R.id.progressBar);
        recyclerView = view.findViewById(R.id.recyclerview);

        searchView.clearFocus();
        recyclerView.setVisibility(View.INVISIBLE);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                progressBar.setVisibility(View.INVISIBLE);
                recyclerView.setVisibility(View.VISIBLE);

            }
        },2000);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        searchAdapter = new SearchAdapter((ArrayList<User>) filterUsers);
        recyclerView.setAdapter(searchAdapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // If there is no text, hide the progress bar and show the recycler view
                if (newText.isEmpty()) {
                    progressBar.setVisibility(View.INVISIBLE);
                    recyclerView.setVisibility(View.VISIBLE);
                    isProgressBarVisible = false;
                } else {
                    // If the progress bar is not currently visible, show it
                    if (!isProgressBarVisible) {
                        progressBar.setVisibility(View.VISIBLE);
                        recyclerView.setVisibility(View.INVISIBLE);
                        isProgressBarVisible = true;
                    }

                    // Remove any previously queued tasks
                    handler.removeCallbacksAndMessages(null);

                    // Queue a task to hide the progress bar after a short delay
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            progressBar.setVisibility(View.INVISIBLE);
                            recyclerView.setVisibility(View.VISIBLE);
                            isProgressBarVisible = false;
                        }
                    }, 500);

                    // Filter the items based on the new text
                    filterItem(newText);
                }
                return true;
            }



        });
    }
    private void filterItem(String newText) {
        filterUsers.clear();
        if (newText.isEmpty()){
            searchAdapter.notifyDataSetChanged();
            return;
        }
        ArrayList<User>users = HomeFragment.dataSource2.getUsers();
        User user = users.get(0);

        for (int i = 0; i < users.size(); i++) {

            User user1 = users.get(i);

            if (i > 0) {

                if (user.getUsername().equals(user1.getUsername()) ||
                        user.getName().equals(user1.getName())) {

                    continue;
                }
            }

            if (user1.getName().toLowerCase().contains(newText.toLowerCase()) ||
                    user1.getUsername().toLowerCase().contains(newText.toLowerCase())) {

                filterUsers.add(user1);
            }

            user = user1;
        }

        searchAdapter.notifyDataSetChanged();
    }
}