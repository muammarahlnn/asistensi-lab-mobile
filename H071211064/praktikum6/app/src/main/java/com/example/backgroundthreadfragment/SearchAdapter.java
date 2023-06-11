package com.example.backgroundthreadfragment;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.CardViewHolder>{
    private ArrayList<ModelDummy> searching;
    Uri uri;

    public SearchAdapter(ArrayList<ModelDummy> searching) {
        this.searching = searching;
    }

    @NonNull
    @Override
    public SearchAdapter.CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_data_search, parent, false);
        return new CardViewHolder(view);
}

    @Override
    public void onBindViewHolder(@NonNull SearchAdapter.CardViewHolder holder, int position) {
        ModelDummy modelDummy = searching.get(position);
        holder.nickname.setText(modelDummy.getNickname());
        holder.username.setText(modelDummy.getUsername());
        holder.profile.setImageURI(modelDummy.getProfile());

        holder.constraintLayout.setOnClickListener(view -> {
//            uri = modelDummy.getProfile();
//            String nickname = modelDummy.getNickname();
//            String username = modelDummy.getUsername();
//            Intent i = new Intent(view.getContext(), PhotoProfileActivity.class);
//            i.putExtra("profile", uri);
//            i.putExtra("nickname", nickname);
//            i.putExtra("username", username);
//            view.getContext().startActivity(i);
            Intent kirim= new Intent(holder.itemView.getContext(),PhotoProfileActivity.class);
            kirim.putExtra("data",modelDummy);
            holder.itemView.getContext().startActivity(kirim);
        });
    }

    @Override
    public int getItemCount() {
        return searching.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {
        ImageView profile;
        TextView nickname, username;
        ConstraintLayout constraintLayout;
        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            profile = itemView.findViewById(R.id.profile_user);
            nickname = itemView.findViewById(R.id.nick_user);
            username = itemView.findViewById(R.id.username_user);
            constraintLayout = itemView.findViewById(R.id.searchdata);
        }

    }
}
