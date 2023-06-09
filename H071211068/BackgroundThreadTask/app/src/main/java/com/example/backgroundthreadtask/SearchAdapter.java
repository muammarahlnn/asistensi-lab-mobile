package com.example.backgroundthreadtask;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.backgroundthreadtask.data.model.User;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.CardViewHolder>{
    private final ArrayList<User> users;

    public SearchAdapter(ArrayList<User> users) {
        this.users = users;
    }

    @NonNull
    @Override
    public SearchAdapter.CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_search, parent, false);
        return new SearchAdapter.CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchAdapter.CardViewHolder holder, int position) {
        User user = users.get(position);

        holder.textView.setText(user.getName());
        holder.textView2.setText(user.getUsername());
        holder.profileImageView.setImageResource(user.getFoto());
        holder.cardSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = users.get(holder.getAdapterPosition());
                Intent intent = new Intent(view.getContext(), Profil.class);
                intent.putExtra("GAMBAR", user.getFoto());
                intent.putExtra("fullname", user.getName());
                intent.putExtra("username", user.getUsername());
                view.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return this.users.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder{

        TextView textView, textView2;
        ImageView profileImageView;
        MaterialCardView cardSearch;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
            textView2 = itemView.findViewById(R.id.textView2);
            cardSearch = itemView.findViewById(R.id.cardSearch);
            profileImageView = itemView.findViewById(R.id.profileImageView);

        }
    }
}
