package com.example.backgroundthreadfragment;

import static com.example.backgroundthreadfragment.HomeFragment.dataList;

import android.content.ClipData;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;


public class SearchFragment extends Fragment {

    SearchView searchView;
    ProgressBar progressBar;
    SearchAdapter myAdapter;
    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        searchView = view.findViewById(R.id.searching);
        recyclerView = view.findViewById(R.id.rvSearch);
        progressBar = view.findViewById(R.id.loading);

        Handler handler = new Handler();
        handler.postDelayed(() ->{
            progressBar.setVisibility(View.INVISIBLE);
        },1000);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                performSearch(newText);
                return true;
            }
        });
    }

    private void performSearch(String query) {
        Log.d("isi string query", String.valueOf(query.isEmpty()));
        ArrayList<ModelDummy> searchResults = new ArrayList<>();

        if (!query.isEmpty()) {
            for (ModelDummy modelDummy : DataDummy.dataDummy) {
                if (modelDummy.getNickname().toLowerCase().contains(query.toLowerCase()) ||
                        modelDummy.getUsername().toLowerCase().contains(query.toLowerCase())) {
                    searchResults.add(modelDummy);
                }
            }
        }
        showSearchResults(searchResults);
    }

    private void showSearchResults(ArrayList<ModelDummy> searchResults) {
        if (searchResults.isEmpty()) {
            Toast.makeText(getActivity(), "No results found", Toast.LENGTH_SHORT).show();
        }
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            myAdapter = new SearchAdapter(searchResults);
            recyclerView.setAdapter(myAdapter);
    }
}