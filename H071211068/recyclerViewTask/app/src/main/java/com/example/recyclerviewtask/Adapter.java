package com.example.recyclerviewtask;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class Adapter extends RecyclerView.Adapter<Adapter.viewHolder> {


    private final List<ModelClass> userlist;

    public Adapter (Context context,List<ModelClass> userlist){
        this.userlist= userlist;
        this.context = context;
    }

    private final Context context;


    @NonNull
    @Override
    public Adapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_design,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.viewHolder holder, int position) {
        int imgResId = userlist.get(position).getImageV();
        String uname = userlist.get(position).getUsername();
        String msg = userlist.get(position).getChat();
        String time = userlist.get(position).getTime1();

        holder.setData(imgResId, uname, msg, time);


        holder.parentLayout.setOnClickListener(view -> {
            int imgResId1 = userlist.get(holder.getAdapterPosition()).getImageV();
            String uname1 = userlist.get(holder.getAdapterPosition()).getUsername();
            String msg1 = userlist.get(holder.getAdapterPosition()).getChat();
            Intent intent = new Intent(context, chatBox.class);
            intent.putExtra("gambar", imgResId1);
            intent.putExtra("nama", uname1);
            intent.putExtra("chat", msg1);
            context.startActivity(intent);
        });




    }

    @Override
    public int getItemCount() {
        return userlist.size();
    }

    public static class viewHolder extends  RecyclerView.ViewHolder{

        private final CircleImageView imageV;
        private final TextView Username;
        private final TextView chat;
        private final TextView time1;

        RelativeLayout parentLayout;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            imageV = itemView.findViewById(R.id.imageV);
            Username =  itemView.findViewById(R.id.username);
            chat = itemView.findViewById(R.id.chat);
            time1 = itemView.findViewById(R.id.time1);
            parentLayout = itemView.findViewById(R.id.parentLayout);
        }

        public void setData(int img, String uname, String msg, String time) {
            imageV.setImageResource(img);
            Username.setText(uname);
            chat.setText(msg);
            time1.setText(time);
        }
    }
}
