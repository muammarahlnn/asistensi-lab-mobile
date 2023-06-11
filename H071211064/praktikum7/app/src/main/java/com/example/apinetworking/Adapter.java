package com.example.apinetworking;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private List<Datum> datumList;


    public Adapter(List<Datum> datumList){
        this.datumList = datumList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from( parent.getContext()).inflate(R.layout.recy_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.textView.setText(datumList.get(position).getFirstName());
        holder.textView2.setText(datumList.get(position).getEmail());
        holder.textView3.setText(datumList.get(position).getLastName());
        String avatarUrl = datumList.get(position).getAvatar();
        Picasso.get().load(avatarUrl).into(holder.imageView);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Profile.class);
                intent.putExtra("name", datumList.get(position).getFirstName());
                intent.putExtra("email", datumList.get(position).getEmail());
                intent.putExtra("lastName", datumList.get(position).getLastName());
                intent.putExtra("avatar", datumList.get(position).getAvatar());
                intent.putExtra("id", datumList.get(position).getId());
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return datumList.size();
    }



    class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView, textView2, textView3;
        ImageView imageView;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            textView = itemView.findViewById(R.id.tvName);
            textView2 = itemView.findViewById(R.id.tvEmail);
            textView3 = itemView.findViewById(R.id.tvLastName);
            imageView = itemView.findViewById(R.id.avatar);

        }
    }

}
