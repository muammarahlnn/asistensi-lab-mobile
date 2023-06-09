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

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ListViewHolder> {
    private ArrayList<ChatMessage> listChatMessage;
    public ChatAdapter(ArrayList<ChatMessage> list){
        this.listChatMessage = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_message, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        ChatMessage data = listChatMessage.get(position);
        holder.message.setText(data.getMessage());
        holder.timeSent.setText(data.getTimeSent());

    }

    @Override
    public int getItemCount() {
        return listChatMessage.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        TextView message, timeSent;
        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            message = itemView.findViewById(R.id.tv_message);
            timeSent = itemView.findViewById(R.id.tv_time);
        }
    }
}
