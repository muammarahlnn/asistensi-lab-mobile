package com.example.backgroundthreadfragment;

import static com.example.backgroundthreadfragment.HomeFragment.dataList;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

    private ArrayList<ModelDummy> users = new ArrayList<>();

    public MyAdapter(ArrayList<ModelDummy> users){
        this.users = users;
    }

    private List<ModelDummy> itemList;

    public void setFilteredList(List<ModelDummy> filteredList) {
        this.itemList= filteredList;
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageResource, user;
        public TextView caption, nicknameUser, usernameUser;
        public LinearLayout linearLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageResource = itemView.findViewById(R.id.postImage);
            caption = itemView.findViewById(R.id.displayCaptionTv);
            user = itemView.findViewById(R.id.userProfileImg);
            nicknameUser = itemView.findViewById(R.id.nickTv);
            usernameUser = itemView.findViewById(R.id.usernameTv);
            linearLayout = itemView.findViewById(R.id.headerPost);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_data, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ModelDummy currentItem = users.get(position);
        holder.caption.setText(currentItem.getCaption());
        holder.user.setImageURI(currentItem.getProfile());
        holder.nicknameUser.setText(currentItem.getNickname());
        holder.usernameUser.setText(currentItem.getUsername());
        holder.imageResource.setImageURI(currentItem.getFoto());
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(),PhotoProfileActivity.class);
                i.putExtra("data", currentItem);
                view.getContext().startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.users.size();
    }
}