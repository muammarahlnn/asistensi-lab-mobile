package com.example.whatsapp_ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

class RecyclerViewAdapterChats extends RecyclerView.Adapter<MyViewHolderChats> {

    private List<MyChats> data = new ArrayList<>();

    @Override
    public MyViewHolderChats onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.text_row_chat_bubble, parent, false);
        return new MyViewHolderChats(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolderChats holder, int position) {
        MyChats item = data.get(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setData(List<MyChats> data) {
        this.data = data;
        notifyDataSetChanged();
    }
}

class MyViewHolderChats extends RecyclerView.ViewHolder {

    private TextView textView;
    private TextView textViewTime;
    public MyViewHolderChats(View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.textViewChats);
        textViewTime = itemView.findViewById(R.id.timeChat);
    }

    public void bind(MyChats item) {
        textView.setText(item.getMessage());
        textViewTime.setText(String.valueOf(item.getTimestamp()));
    }

}