package com.attar.networkingassignment;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.attar.networkingassignment.data.UserResponse;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private final List<UserResponse> users = new ArrayList<>();

    public void setUsers(List<UserResponse> users){
        this.users.addAll(users);
    }



    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder (@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder (@NonNull Adapter.ViewHolder holder, int position) {
        UserResponse user = users.get(position);
        holder.setData(user);


    }

    @Override
    public int getItemCount () {
        return users.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {


        private final TextView tvUsername;
        private final ImageView ivFotoProfile;
        private final TextView tvemail;
        public ViewHolder (View view) {
            super(view);
            tvUsername = itemView.findViewById(R.id.tv_username);
            tvemail = itemView.findViewById(R.id.tv_email);
            ivFotoProfile = itemView.findViewById(R.id.iv_fotoProfile);
        }



        public void setData (UserResponse user) {
            if (user != null) {
                String fullName = user.getFirstName() + " " + user.getLastName();
                tvUsername.setText(fullName);
                tvemail.setText(user.getEmail());
                Glide.with(itemView.getContext())
                        .load(user.getAvatarUrl())
                        .into(ivFotoProfile);

                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick (View view) {
                        Intent toProfile = new Intent(itemView.getContext(), ProfileActivity.class);
                        toProfile.putExtra("id", user.getId());
                        itemView.getContext().startActivity(toProfile);
                    }
                });
            }

        }
    }
}
