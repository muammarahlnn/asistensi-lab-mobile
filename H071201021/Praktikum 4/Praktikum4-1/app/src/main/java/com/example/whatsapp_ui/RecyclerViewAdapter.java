package com.example.whatsapp_ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

class RecyclerViewAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private List<MyData> data = new ArrayList<>();

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.text_row_chat, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        MyData item = data.get(position);
        holder.bind(item);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent kirim = new Intent(holder.itemView.getContext(), ChatsActivity.class);
                String name = item.getName();
                String noTelp = item.getNoTelp();
                String status = item.getStatus();
                String statusDate = item.getStatusDate();
                int drawableId = item.getDrawableId();
                ArrayList<MyChats> chatData = item.getChats();
                kirim.putExtra("name", name);
                kirim.putExtra("drawable_id", drawableId);
                kirim.putExtra("chats", chatData);

                kirim.putExtra("noTelp", noTelp);
                kirim.putExtra("status", status);
                kirim.putExtra("statusDate", statusDate);

                holder.itemView.getContext().startActivity(kirim);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setData(List<MyData> data) {
        this.data = data;
        notifyDataSetChanged();
    }
}

class MyViewHolder extends RecyclerView.ViewHolder {

    private TextView textViewName;
    private TextView textViewChats;
    private TextView textViewTimeChat;
    private CircleImageView circleImageViewUser;
    private MyData myData;

    public MyViewHolder(View itemView) {
        super(itemView);
        textViewName = itemView.findViewById(R.id.textViewName);
        textViewChats = itemView.findViewById(R.id.textViewChats);
        textViewTimeChat = itemView.findViewById(R.id.timeChat);
        circleImageViewUser = itemView.findViewById(R.id.circleImageViewUser);
    }

    public void bind(MyData item) {
        textViewName.setText(item.getName());
        ArrayList<MyChats> chatData = item.getChats();
        String lastChat = chatData.get(chatData.size() - 1).getMessage();
        String lastTimeStamp = chatData.get(chatData.size() - 1).getTimestamp();

        textViewChats.setText(lastChat);
        textViewTimeChat.setText(lastTimeStamp);
        circleImageViewUser.setImageResource(item.getDrawableId());
        myData = item;

        circleImageViewUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // access the name variable of MyData using myData.getName()
                Intent kirim = new Intent(itemView.getContext(), ProfilePicture.class);
                String name = item.getName();
                int drawableId = item.getDrawableId();

                kirim.putExtra("name", name);
                kirim.putExtra("drawable_id", drawableId);
                itemView.getContext().startActivity(kirim);
            }
        });
    }

}

class MyData {
    private String name;
    private int drawableId;
    private ArrayList<MyChats> chats;
    private String noTelp;
    private String status;
    private String statusDate;

    public MyData(String name, int drawableId, ArrayList<MyChats> chats, String noTelp, String status, String statusDate) {
        this.name = name;
        this.drawableId = drawableId;
        this.chats = chats;
        this.noTelp = noTelp;
        this.status = status;
        this.statusDate = statusDate;
    }

    public MyData(String name, ArrayList<MyChats> chats, String noTelp, String status, String statusDate) {
        this.name = name;
        this.drawableId = R.drawable.baseline_person_24;
        this.chats = chats;
        this.noTelp = noTelp;
        this.status = status;
        this.statusDate = statusDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDrawableId() {
        return drawableId;
    }

    public void setDrawableId(int drawableId) {
        this.drawableId = drawableId;
    }

    public ArrayList<MyChats> getChats() {
        return chats;
    }

    public void setChats(ArrayList<MyChats> chats) {
        this.chats = chats;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusDate() {
        return statusDate;
    }

    public void setStatusDate(String statusDate) {
        this.statusDate = statusDate;
    }
}


class MyChats implements Serializable {
    private String message;
    private String timestamp;

    public MyChats(String message, String timestamp) {
        this.message = message;
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}




