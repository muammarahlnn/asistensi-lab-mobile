package com.example.fragmentassigment;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {
    Context context;
    private ArrayList<PostModel> dataList;

    public PostAdapter(Context context, ArrayList<PostModel> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public PostAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_post, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.tvCaption.setText(dataList.get(position).getCaption());
        holder.tvUser.setText(dataList.get(position).getUsername());

        Glide
                .with(holder.itemView)
                .load(dataList.get(position).getProfile())
                .centerCrop()
                .into(holder.ivProfile);

        Glide
                .with(holder.itemView)
                .load(dataList.get(position).getUpload())
                .centerCrop()
                .into(holder.ivUpload);

        holder.ivProfile.setOnClickListener(view -> {
            Intent intent = new Intent(holder.itemView.getContext(), ProfileActivity.class);
            intent.putExtra(ProfileActivity.EXTRA_USER, dataList.get(position));
            holder.itemView.getContext().startActivity(intent);
        });

        holder.tvUser.setOnClickListener(view -> {
            Intent intent = new Intent(holder.itemView.getContext(), ProfileActivity.class);
            intent.putExtra(ProfileActivity.EXTRA_USER, dataList.get(position));
            holder.itemView.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvCaption, tvUser;
        ImageView ivUpload, ivProfile;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCaption = itemView.findViewById(R.id.tv_caption);
            tvUser = itemView.findViewById(R.id.tv_user);
            ivUpload = itemView.findViewById(R.id.iv_upload);
            ivProfile = itemView.findViewById(R.id.iv_profile);
        }
    }
}