package com.example.fragment;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {
    private final ArrayList<Home> homes;

    public HomeAdapter(ArrayList<Home> homes) {
        this.homes = homes;
    }
    @NonNull
    @Override
    public HomeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_home,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeAdapter.ViewHolder holder, int position) {
        Home home = homes.get(position);
        holder.setData(home);
        holder.profil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), ProfileActivity.class);
                intent.putExtra("home", home);
                holder.itemView.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return homes.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private TextView tvUsername, tvFullName, tvCaption;
        private ImageView profil, postPhoto;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
//            tvFullName = itemView.findViewById(R.id.full_name);
            tvUsername = itemView.findViewById(R.id.username);
            tvCaption = itemView.findViewById(R.id.caption);
            profil = itemView.findViewById(R.id.profil);
            postPhoto = itemView.findViewById(R.id.img_post);
        }
        public void setData(Home home) {
//            tvFullName.setText(home.getFullName());
            tvUsername.setText(home.getUsername());
            tvCaption.setText(home.getCaption());
            profil.setImageResource(home.getProfile());
            if (home.getPhotoUri() != null) {
                postPhoto.setImageURI(home.getPhotoUri());
            } else {
                postPhoto.setImageResource(home.getProfile());
            }
        }
    }
}
