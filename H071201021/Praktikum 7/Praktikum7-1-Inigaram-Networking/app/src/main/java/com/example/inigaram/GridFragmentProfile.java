package com.example.inigaram;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class GridFragmentProfile extends Fragment {
    private RecyclerView rvProfileGrid;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_grid_profile, container, false);
        rvProfileGrid = view.findViewById(R.id.rv_profile_grid);

        rvProfileGrid.setLayoutManager(new GridLayoutManager(getActivity(), 3));

        // set adapter to rv
        SearchAdapter adapter = new SearchAdapter(DataSource.posts);
        rvProfileGrid.setAdapter(adapter);
        adapter.setOnItemClickCallBack(new SearchAdapter.OnItemClickCallBack() {
            @Override
            public void onItemClicked(Post post) {
                Toast.makeText(getContext(), "GridFragment Fullname : " + post.getFullname(), Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}