package com.example.backgroundthreadfragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class AdapterDummy extends RecyclerView.Adapter<AdapterDummy.CardViewHolder> {

    private ArrayList<ModelDummy> dataDummy;

    ModelDummy modelDummy;
    Uri uri;

    public AdapterDummy(ArrayList<ModelDummy> dataDummy) { this.dataDummy = dataDummy;}
    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_data, parent, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        ModelDummy dummy = dataDummy.get(position);
        holder.nickname.setText(dummy.getNickname());
        holder.username.setText(dummy.getUsername());
        holder.caption.setText(dummy.getCaption());

//        Glide.with(holder.itemView.getContext())
//                .load(dummy.getFoto())
//                .apply(new RequestOptions().override(350, 550))
//                .into(holder.profile);

        holder.profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent kirim= new Intent(holder.itemView.getContext(),ModelDummy.class);
                kirim.putExtra("person",dummy);
                holder.itemView.getContext().startActivity(kirim);
            }
        });

        holder.foto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uri = dummy.getProfile();
                String nickname = dummy.getNickname();
                String username = dummy.getUsername();
                Intent i = new Intent(view.getContext(), PhotoProfileActivity.class);
                i.putExtra("profile", uri);
                i.putExtra("nickname", nickname);
                i.putExtra("username", username);
                view.getContext().startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataDummy.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder{
        ImageView profile, foto;
        TextView nickname, username, caption;
        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            profile = itemView.findViewById(R.id.userProfileImg);
            nickname = itemView.findViewById(R.id.nickTv);
            username = itemView.findViewById(R.id.usernameTv);
            foto = itemView.findViewById(R.id.postImage);
            caption = itemView.findViewById(R.id.displayCaptionTv);
        }
    }
}
