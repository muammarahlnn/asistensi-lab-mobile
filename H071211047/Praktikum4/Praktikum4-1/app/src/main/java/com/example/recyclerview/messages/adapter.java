package com.example.recyclerview.messages;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.R;

import java.util.ArrayList;

public class adapter extends RecyclerView.Adapter<adapter.ViewHolder> {
    private final ArrayList<IsiChat> isichat;

    public adapter(ArrayList<IsiChat> isichat) {this.isichat = isichat;
    }

    @NonNull
    @Override
    public adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tampilanchat, parent, false);
        return new adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull adapter.ViewHolder holder, int position) {
        IsiChat data = isichat.get(position);
        holder.setData(data);
    }

    @Override
    public int getItemCount() {
        return isichat.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView time;
        private final TextView text;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            time = itemView.findViewById(R.id.time);
            text = itemView.findViewById(R.id.text);
        }

        public void setData(IsiChat data) {
            time.setText(data.getWaktu());
            text.setText(data.getIsichat());
        }
    }
}
