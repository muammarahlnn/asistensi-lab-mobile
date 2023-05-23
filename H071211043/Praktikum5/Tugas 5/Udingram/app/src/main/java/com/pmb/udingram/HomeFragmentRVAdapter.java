package com.pmb.udingram;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pmb.udingram.databinding.PostListBinding;

import java.util.LinkedList;

public class HomeFragmentRVAdapter extends RecyclerView.Adapter<HomeFragmentRVAdapter.ViewHolder> {

    LinkedList<UserPostData> dataSource;

    HomeFragmentRVAdapter(LinkedList<UserPostData> dataSource) {
        this.dataSource = dataSource;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        PostListBinding binding = PostListBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        UserPostData userPostData = dataSource.get(position);
        holder.binding.postImg.setImageURI(userPostData.getImagePost());
        holder.binding.postImg.setImageTintList(null);
        holder.binding.captionPost.setText(userPostData.getCaption());

    }

    @Override
    public int getItemCount() {
        return dataSource.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        PostListBinding binding;

        public ViewHolder(PostListBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

            binding.userLayout.setOnClickListener(v -> {
                Intent intent = new Intent(v.getContext(), ProfileActivity.class);
                v.getContext().startActivity(intent);
            });
        }
    }
}