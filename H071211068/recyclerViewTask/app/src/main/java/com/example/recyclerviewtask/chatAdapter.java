package com.example.recyclerviewtask;

import static com.example.recyclerviewtask.ChatClass.LAYOUT_ONE;
import static com.example.recyclerviewtask.ChatClass.LAYOUT_TWO;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class chatAdapter extends RecyclerView.Adapter {

    List<ChatClass> list;
    Context context;

    public chatAdapter(List<ChatClass> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        switch (list.get(position).getViewType())
        {
            case 1:
                return LAYOUT_ONE;

            case 2:
                return LAYOUT_TWO;


            default:
                return -1;
        }
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType){
            case 1:
                View layoutone = LayoutInflater.from(context).inflate(R.layout.sender_message,parent,false);
                return new senderMessageViewHolder(layoutone);

            case 2:
                View layouttwo = LayoutInflater.from(context).inflate(R.layout.receiver_message,parent,false);
                return new receiverMessageViewHolder(layouttwo);

            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        switch (list.get(position).getViewType())
        {
            case 1:
                String sm = list.get(position).getMessage();
                ((senderMessageViewHolder) holder).setView(sm);
                break;
            case 2:
                String rm = list.get(position).getMessage();
                ((receiverMessageViewHolder) holder).setView(rm);
                break;
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class senderMessageViewHolder extends RecyclerView.ViewHolder{

        private final TextView tv_sm;

        public senderMessageViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_sm = itemView.findViewById(R.id.tv_sm);
        }
        private void setView(String text){
            tv_sm.setText(text);
        }
    }

    static class receiverMessageViewHolder extends RecyclerView.ViewHolder{

        private final TextView tv_rm;

        public receiverMessageViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_rm = itemView.findViewById(R.id.tv_rm);
        }
        private void setView(String text){
            tv_rm.setText(text);
        }
    }



}
