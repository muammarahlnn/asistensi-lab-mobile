package com.example.inigaram;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class SearchFragment extends Fragment {
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
        rvSearch = view.findViewById(R.id.rv_search);

        rvSearch.setLayoutManager(new GridLayoutManager(getActivity(), 3));

        // set adapter to rv
        SearchAdapter adapter = new SearchAdapter(DataSource.posts);
        rvSearch.setAdapter(adapter);
        adapter.setOnItemClickCallBack(new SearchAdapter.OnItemClickCallBack() {
            @Override
            public void onItemClicked(Post post) {
                Toast.makeText(getContext(), "Fullname : " + post.getFullname(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}