package com.attar.fragmentassignment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder> {

    private final ArrayList<User> users = new ArrayList<>();

    public void setUsers(ArrayList<User> users){
        if(this.users.size() > 0){
            this.users.clear();
        }
        this.users.addAll(users);
    }



    @NonNull
    @Override
    public SearchAdapter.ViewHolder onCreateViewHolder (@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemsearch, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder (@NonNull SearchAdapter.ViewHolder holder, int position) {
        User user = users.get(position);
        holder.setData(user);


    }

    @Override
    public int getItemCount () {
        return users.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {


        private final TextView tvUsername;
        private final ImageView ivFotoProfile;
        private final TextView tvFullnname;
        public ViewHolder (View view) {
            super(view);
            tvUsername = itemView.findViewById(R.id.tv_username);
            tvFullnname = itemView.findViewById(R.id.tv_fullName);
            ivFotoProfile = itemView.findViewById(R.id.iv_fotoProfile);
        }



        public void setData (User user) {
            tvUsername.setText(user.getUsername());
            tvFullnname.setText(user.getFullname());
            ivFotoProfile.setImageResource(user.getImageRes());

        }
    }
}
