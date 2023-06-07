package com.example.localdata;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder>{
    private final ArrayList<Note> notes = new ArrayList<>();

    public ArrayList<Note> getNotes() {
        return notes;
    }

    @NonNull
    @Override
    public NoteAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_view,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteAdapter.ViewHolder holder, int position) {
        Note note = notes.get(position);
        holder.setData(note);
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public void addNote(Note note) {
        this.notes.add(note);
        notifyItemInserted(this.notes.size() - 1);
    }

    public void setData(ArrayList<Note> notes) {
        if (this.notes.size() > 0) {
            this.notes.clear();
        }
        this.notes.addAll(notes);
        notifyDataSetChanged();

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvTitle, tvDescription, tvDate;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvDescription = itemView.findViewById(R.id.tv_description);
            tvDate = itemView.findViewById(R.id.tv_date);
        }

        public void setData(Note note) {
            tvTitle.setText(note.getTitle());
            tvDescription.setText(note.getDescription());
            tvDate.setText(note.getDate());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(itemView.getContext(), MainActivity2.class);
                    if (note != null) {
                        intent.putExtra(MainActivity2.EXTRA_NOTE,note);
                    }
                    itemView.getContext().startActivity(intent);
                }
            });
        }
    }
}
