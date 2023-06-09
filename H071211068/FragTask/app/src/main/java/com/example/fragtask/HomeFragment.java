package com.example.fragtask;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;


public class HomeFragment extends Fragment {
    private TextView warn;
    private RecyclerView rv;
    private static ArrayList<timeline> postList;
    private static PostAdapter adapter;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        warn = view.findViewById(R.id.warning);
        rv = view.findViewById(R.id.RV);

        if (postList == null) {
            postList = new ArrayList<>();
        }

        adapter = new PostAdapter(postList, getContext());
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setAdapter(adapter);

        Bundle bundle = getArguments();
        if (bundle == null) {
            warn.setVisibility(View.VISIBLE);
            rv.setVisibility(View.GONE);
        } else {
            Uri uri = bundle.getParcelable("img");
            String putCapt = bundle.getString(PostFragment.Key1);

            boolean isDataExists = false;
            for (timeline post : postList) {
                if (post.getCapt().equals(putCapt) && post.getImageUrl().equals(uri)) {
                    isDataExists = true;
                    break;
                }
            }

            if (!isDataExists) {
                postList.add(0, new timeline( uri, putCapt));
                adapter.notifyItemInserted(0);
            }
            warn.setVisibility(View.GONE);
            rv.setVisibility(View.VISIBLE);
        }

        return view;
    }
}