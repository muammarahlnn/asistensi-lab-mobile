package com.example.fragment;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterPosting extends RecyclerView.Adapter<AdapterPosting.ViewHolder> {
    private ArrayList<ModelClass> dataList;

    public AdapterPosting(ArrayList<ModelClass> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.desainpost, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ModelClass model = dataList.get(position);
        holder.caption1.setText(model.getCaption());
        Uri pictureUri = Uri.parse(model.getPictureUri());
        holder.picture1.setImageURI(pictureUri);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView picture1;
        ImageView profile1;
        TextView caption1;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            profile1 = itemView.findViewById(R.id.profile);
            picture1 = itemView.findViewById(R.id.picture1);
            caption1 = itemView.findViewById(R.id.caption1);

            profile1.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.profile) {
                // Mengambil posisi item yang diklik
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    // Mengambil data ModelClass berdasarkan posisi
                    ModelClass model = dataList.get(position);

                    // Mengirim data ke halaman DetailProfileActivity
                    Intent intent = new Intent(itemView.getContext(), detailProfile.class);
                    intent.putExtra("profileId", model.getProfile1()); // Mengirim ID profile sebagai data tambahan
                    itemView.getContext().startActivity(intent);
                }
            }
        }
    }
}
