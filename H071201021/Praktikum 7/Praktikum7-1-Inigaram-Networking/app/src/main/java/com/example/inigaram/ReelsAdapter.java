package com.example.inigaram;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ReelsAdapter extends RecyclerView.Adapter<ReelsAdapter.GridViewHolder>{
    private ArrayList<Post> posts;
    public ReelsAdapter(ArrayList<Post> posts) {
        this.posts = posts;
    }
    public interface OnItemClickCallBack {
        void onItemClicked(Post posts);
    }
    private OnItemClickCallBack callBack;
    public void setOnItemClickCallBack(OnItemClickCallBack callBack){
        this.callBack = callBack;
    }

    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid, parent, false);
        return new GridViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull GridViewHolder holder, int position) {
        Glide.with(holder.itemView.getContext()).load(posts.get(position).getPostPicture()).apply(new RequestOptions().override(350, 600)).into(holder.ivGrid);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callBack.onItemClicked(posts.get(holder.getAdapterPosition()));
            }
        });
    }
    @Override
    public int getItemCount() {
        return posts.size();
    }
    public class GridViewHolder extends RecyclerView.ViewHolder {
        ImageView ivGrid;
        public GridViewHolder(@NonNull View itemView) {
            super(itemView);
            ivGrid = itemView.findViewById(R.id.iv_grid);
        }
    }
}
