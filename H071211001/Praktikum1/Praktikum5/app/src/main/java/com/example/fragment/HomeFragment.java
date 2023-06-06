package com.example.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;
    private AdapterPosting adapterPosting;
    private ArrayList<ModelClass> dataList;

    public static HomeFragment newInstance(ModelClass data) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putParcelable("data", data);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        // Mendapatkan data dari argumen
        Bundle args = getArguments();
        if (args != null) {
            ModelClass data = args.getParcelable("data");
            if (data != null) {
                // Gunakan data yang diterima di sini

                SimpanData.setDataPost(data);
            }
        }
        adapterPosting = new AdapterPosting(SimpanData.getDataPost());
        recyclerView.setAdapter(adapterPosting);

        return view;
    }
}
