package com.example.fragtask;

import android.content.Context;
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

import de.hdodenhof.circleimageview.CircleImageView;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {
    private final ArrayList<timeline> postList;
    private final Context context;

    public PostAdapter(ArrayList<timeline> postList, Context context) {
        this.postList = postList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tline_rv, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        timeline post = postList.get(position);
        holder.caption.setText(post.getCapt());
        holder.image.setImageURI(post.getImageUrl());

        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), MainActivity2.class);
                holder.itemView.getContext().startActivity(intent);
            }
        });
        holder.user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), MainActivity2.class);
                holder.itemView.getContext().startActivity(intent);
            }
        });
        holder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), MainActivity2.class);
                holder.itemView.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView caption,user,name;
        ImageView image;
        CircleImageView img;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            caption = itemView.findViewById(R.id.captiontxt);
            user = itemView.findViewById(R.id.userr);
            name = itemView.findViewById(R.id.namee);
            image = itemView.findViewById(R.id.imageContent);
            img = itemView.findViewById(R.id.profile_img);

        }
    }
}