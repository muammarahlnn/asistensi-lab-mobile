package com.attar.tugas4;

import android.content.ClipData;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.attar.tugas4.databinding.ItemchatBinding;

import java.sql.Time;
import java.util.ArrayList;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {


    private ArrayList<Contact>contacts;

    private ClickListener clickListener;

    public ContactAdapter(ArrayList<Contact> contacts) {
        this.contacts = contacts;
    }

    public void setClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemchatBinding binding = ItemchatBinding.inflate(
                LayoutInflater.from(parent.getContext()),parent,false
        );
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(contacts.get(position));

    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private ItemchatBinding binding;
        public ViewHolder(@NonNull ItemchatBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
        public void onBind(Contact contact){
            binding.tvContact.setText(contact.getContact());
            binding.tvChat.setText(contact.getChat());
            binding.tvTime.setText(contact.getTime());
            binding.profileImage.setImageResource(contact.getProfilePicture());
            binding.getRoot().setOnClickListener(view -> {
                clickListener.onItemCLicked(contact);
            });
        }
    }

    interface ClickListener {
        void onItemCLicked(Contact contact);
    }
}
