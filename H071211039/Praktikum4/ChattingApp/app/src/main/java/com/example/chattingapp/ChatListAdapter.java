package com.example.chattingapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ChatListAdapter extends RecyclerView.Adapter<ChatListAdapter.ChatListHolder> {
    private final ArrayList<ChatList> listChat;

    public ChatListAdapter(ArrayList<ChatList> list){
        this.listChat = list;
    }

    @NonNull
    @Override
    public ChatListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_roomchat,parent, false);
        return new ChatListHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChatListAdapter.ChatListHolder holder, int position) {
        ChatList chatList = listChat.get(position);
        holder.setData(chatList);
    }

    @Override
    public int getItemCount() {
        return listChat.size();
    }

    public class ChatListHolder extends RecyclerView.ViewHolder {
        private TextView tv_message, tv_time;
        public ChatListHolder(@NonNull View itemView) {
            super(itemView);
            tv_message = itemView.findViewById(R.id.tv_message);
            tv_time = itemView.findViewById(R.id.tv_time);
        }
        public void setData (ChatList listChat){
            tv_message.setText(listChat.getMessage());
            tv_time.setText(listChat.getTime());
        }
    }
}