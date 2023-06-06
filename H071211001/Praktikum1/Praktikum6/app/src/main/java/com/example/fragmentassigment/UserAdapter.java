package com.example.fragmentassigment;

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

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    ArrayList<PostModel> dataList = new ArrayList<>();

    public void setDataList(ArrayList<PostModel> dataList) {
        if (this.dataList.size() > 0) {
            this.dataList.clear();
        }
        this.dataList.addAll(dataList);
    }

    @NonNull
    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_user, parent, false);
        return new UserAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.ViewHolder holder, int position) {
        Glide
                .with(holder.itemView)
                .load(dataList.get(position).getProfile())
                .centerCrop()
                .into(holder.ivProfile);

        holder.tvUser.setText(dataList.get(position).getUsername());
        holder.tvName.setText(dataList.get(position).getName());

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

        holder.tvName.setOnClickListener(view -> {
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
        ImageView ivProfile;
        TextView tvUser, tvName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvUser = itemView.findViewById(R.id.tv_username_user);
            tvName = itemView.findViewById(R.id.tv_name_user);
            ivProfile = itemView.findViewById(R.id.iv_photo_user);
        }
    }
}