package com.attar.fragmentassignment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {

    private final ArrayList<User> users = new ArrayList<>();

    public void setUsers(ArrayList<User> users){
        if(this.users.size() > 0){
            this.users.clear();
        }
        this.users.addAll(users);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder (@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itempost, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder (@NonNull ViewHolder holder, int position) {
        User user = users.get(position);
        holder.setData(user);

    }

    @Override
    public int getItemCount () {
        return users.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView tvCaption;
        private final TextView tvUsername;
        private final ImageView ivFotoProfile;
        private final ImageView ivPost;
        public ViewHolder (@NonNull View itemView) {
            super(itemView);
            tvCaption = itemView.findViewById(R.id.tv_caption);
            tvUsername = itemView.findViewById(R.id.tv_username);
            ivPost = itemView.findViewById(R.id.iv_post);
            ivFotoProfile = itemView.findViewById(R.id.iv_fotoProfile);

        }

        public void setData (User user) {
            tvCaption.setText(user.getPost().getCaption());
            tvUsername.setText(user.getUsername());
            ivFotoProfile.setImageResource(user.getImageRes());

            if(user.getPost().getPhotoUri() != null) {
                ivPost.setImageURI(user.getPost().getPhotoUri());
            } else {
                ivPost.setImageResource(user.getImageRes());
            }

        }
    }
}
