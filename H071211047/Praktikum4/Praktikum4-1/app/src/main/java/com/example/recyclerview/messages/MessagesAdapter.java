package com.example.recyclerview.messages;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.recyclerview.R;

import java.util.ArrayList;
import java.util.List;

public class MessagesAdapter extends RecyclerView.Adapter<MessagesAdapter.MyViewHolder> {

    private final ArrayList<ChatModel> chat;
    public MessagesAdapter(ArrayList<ChatModel> chat) { this.chat = chat; }

    @NonNull
    @Override
    public MessagesAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.messages_adapter_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MessagesAdapter.MyViewHolder holder, int position) {
        ChatModel chats = chat.get(position);
        holder.setData(chats);
        holder.profil.setOnClickListener(view -> {
            Intent intent = new Intent(holder.itemView.getContext(), ProfileChatActivity.class);
            intent.putExtra(com.example.recyclerview.messages.ProfileChatActivity.EXTRA_CHATDATA, chats);
            holder.itemView.getContext().startActivity(intent);
        });
        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(holder.itemView.getContext(), TampilanUtamaActivity.class);
            intent.putExtra(com.example.recyclerview.messages.TampilanUtamaActivity.EXTRA_DATACHAT, chats);
            holder.itemView.getContext().startActivity(intent);
        });
        }

    @Override
    public int getItemCount() {
        return chat.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private final ImageView profil;
        private final TextView nama, lastchat, waktu;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            profil = itemView.findViewById(R.id.image);
            nama = itemView.findViewById(R.id.nama);
            lastchat = itemView.findViewById(R.id.lastchat);
            waktu = itemView.findViewById(R.id.waktu);
        }

        public void setData(ChatModel chat) {
            nama.setText(chat.getNama());
            Glide.with(itemView.getContext()).load(chat.getFoto()).apply(new RequestOptions().override(350,350)).into(profil);
            lastchat.setText(chat.getChat());
            waktu.setText(chat.getWaktu());
        }
    }
}
