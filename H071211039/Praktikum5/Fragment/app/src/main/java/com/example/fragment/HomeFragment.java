package com.example.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

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

        if (DataSource.homes.size() > 0) {
            TextView tv = view.findViewById(R.id.tvJudul);
            tv.setVisibility(View.GONE);
        }

        //bagaiamana cara menampilkan data dari database ke recyclerview
        RecyclerView rvHome = view.findViewById(R.id.rvHome);
        rvHome.setLayoutManager(new LinearLayoutManager(getActivity()));

        HomeAdapter adapter = new HomeAdapter(DataSource.homes);
        rvHome.setAdapter(adapter);
    }


}