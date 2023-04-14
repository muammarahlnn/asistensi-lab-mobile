package com.example.praktikum4_1;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListAppChatAdapter extends RecyclerView.Adapter<ListAppChatAdapter.ListViewHolder> implements View.OnClickListener {
    private ArrayList<Data> listData;
    public ListAppChatAdapter(ArrayList<Data> list){
        this.listData = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_chat, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        Data data = listData.get(position);
        holder.itemView.setOnClickListener(holder);
        Glide.with(holder.itemView.getContext())
                .load(data.getPhoto())
                .apply(new RequestOptions().override(200, 200))
                .into(holder.imgPhoto);
        holder.tv_nama.setText(data.getName());
        holder.tv_preview.setText(data.getDetail());

    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public void onClick(View view) {

    }

    public class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imgPhoto;
        TextView tv_nama, tv_preview;
        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.iv_profile);
            tv_nama = itemView.findViewById(R.id.tv_name);
            tv_preview = itemView.findViewById(R.id.tv_preview);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View itemView) {
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {
                imgPhoto.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Data data = listData.get(position);
                        Intent intent = new Intent(itemView.getContext(), ProfilepicActivity.class);
                        intent.putExtra("DATA", data);
                    }
                });
                Data data = listData.get(position);
                Intent intent = new Intent(itemView.getContext(), ChatActivity.class);
                intent.putExtra("DATA", data);

                try {
                    itemView.getContext().startActivity(intent);
                } catch (ActivityNotFoundException e) {
                    Log.e("TAG", "Error starting activity: " + e.getMessage());
                }
            }
        }
    }
}