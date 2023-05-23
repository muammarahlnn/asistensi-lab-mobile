package com.example.chattingapp;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder>{
    private final ArrayList<Chat> chats;
//

    public ChatAdapter(ArrayList<Chat> chats){
        this.chats = chats;
    }
//   public void setClickListener(clickListener)

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_chat,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Chat chat = chats.get(position);
        holder.setData(chat);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = chats.get(holder.getAdapterPosition()).getName();
                String nohp = chats.get(holder.getAdapterPosition()).getNoHP();
                String status = chats.get(holder.getAdapterPosition()).getStatus();
                String statusDate = chats.get(holder.getAdapterPosition()).getStatusDate();
                int profil =  chats.get(holder.getAdapterPosition()).getImage();
                Intent intent =new Intent(holder.itemView.getContext(), MainActivity2.class);
                String chat = chats.get(holder.getAdapterPosition()).getChat();
                String time = chats.get(holder.getAdapterPosition()).getTime();

                intent.putExtra("name", name);
                intent.putExtra("nohp", nohp);
                intent.putExtra("status", status);
                intent.putExtra("statusDate", statusDate);
                intent.putExtra("profil", profil);
                intent.putExtra("chat", chat);
                intent.putExtra("time", time);
                holder.itemView.getContext().startActivity(intent);
            }
        });

        holder.profil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = chats.get(holder.getAdapterPosition()).getName();
                int profil =  chats.get(holder.getAdapterPosition()).getImage();

                Intent intent = new Intent(view.getContext(),MainActivity4.class);
                intent.putExtra("name", name);
                intent.putExtra("profil", profil);
                holder.itemView.getContext().startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return chats.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private final TextView tvName;
        private final TextView tvChat;
        private final TextView tvTime;
        private final ImageView profil;
        public ViewHolder(View itemView){
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            tvChat = itemView.findViewById(R.id.tv_chat);
            tvTime = itemView.findViewById(R.id.tv_time);
            profil = itemView.findViewById(R.id.profil);
        }
        public void setData (Chat chat){
            tvName.setText(chat.getName());
            tvChat.setText(chat.getChat());
            tvTime.setText(chat.getTime());
            profil.setImageResource(chat.getImage());

        }
//        interface ClickListener(
//                void onChatClicked(chat chat);
//        );
    }
}