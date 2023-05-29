package com.example.fragment;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder>{
    private final ArrayList<Home> searches;

    public SearchAdapter(ArrayList<Home> searches) {this.searches = searches;}



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_search,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Home home = searches.get(position);
        holder.setData(home);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), ProfileActivity.class);
                intent.putExtra("home", home);
                holder.itemView.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {return searches.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvUsername, tvFullName;
        private ImageView profil;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvFullName = itemView.findViewById(R.id.tvFullName);
            tvUsername = itemView.findViewById(R.id.tvUsername);
            profil = itemView.findViewById(R.id.profile);

        }

        public void setData(Home home) {
            tvFullName.setText(home.getFullName());
            tvUsername.setText(home.getUsername());
            profil.setImageResource(home.getProfile());
        }
    }
}
