package com.example.fragment1;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.MyViewHolder> {

    private ArrayList<PostModel> listData;

    public ItemAdapter(ArrayList<PostModel> listData){
        this.listData = listData;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{
        public ImageView profileImage, postImage;
        public TextView userName, profileName, captionPost;

        public MyViewHolder(@NonNull View itemView){
            super(itemView);

            this.profileImage = itemView.findViewById(R.id.avatarProfile);
            this.postImage = itemView.findViewById(R.id.pickPhoto);
            this.userName = itemView.findViewById(R.id.userName);
            this.profileName = itemView.findViewById(R.id.profileName);
            this.captionPost = itemView.findViewById(R.id.captionText);
        }
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View listItem = inflater.inflate(R.layout.recycler_item,parent,false);
        MyViewHolder viewHolder = new MyViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final PostModel myListData = listData.get(position);
        holder.profileImage.setImageResource(R.drawable.avatar);
        holder.profileName.setText("John Wick");
        holder.userName.setText("the boogeyman");

        if(listData.get(position).getImagePick() == null){
            holder.postImage.setVisibility(View.GONE);
        }else{
            holder.postImage.setImageURI(listData.get(position).getImagePick());
        }
        //Set postImage if using URL if there is one and make else statement to set postImage to null


        holder.captionPost.setText(listData.get(position).getCaptionPost());

        holder.profileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(),Profile.class);
                view.getContext().startActivity(i);
            }
        });
    }


    @Override
    public int getItemCount() {

        if(listData == null){
            return 0;
        }else{
            return listData.size();
        }
    }

}
