package com.pmb.udingram;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.pmb.udingram.databinding.FragmentHomeBinding;

import java.util.LinkedList;

public class HomeFragment extends Fragment {

    FragmentHomeBinding binding;
    Bundle bundle;
    LinkedList<UserPostData> userPostDataLinkedList = new LinkedList<>();
    UserPostData userPostData;
    HomeFragmentRVAdapter adapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View v = binding.getRoot();

        Animation fadeIn = AnimationUtils.loadAnimation(getContext(), R.anim.fade_in_animation);
        binding.homeFragment.startAnimation(fadeIn);


        bundle = getArguments();
        if (bundle!=null){
            userPostData = bundle.getParcelable("postData");
            userPostDataLinkedList.addFirst(userPostData);
            Toast.makeText(getActivity(), "Telah terupload!", Toast.LENGTH_SHORT).show();
        }

        if (userPostDataLinkedList.size() != 0){
            binding.status.setVisibility(View.GONE);
            binding.postRecyclerView.setVisibility(View.VISIBLE);
        }else{
            binding.postRecyclerView.setVisibility(View.GONE);
            binding.status.setVisibility(View.VISIBLE);
        }

        adapter = new HomeFragmentRVAdapter(userPostDataLinkedList);
        adapter.notifyItemInserted(userPostDataLinkedList.size() + 1);
        binding.postRecyclerView.setAdapter(adapter);
        binding.postRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}