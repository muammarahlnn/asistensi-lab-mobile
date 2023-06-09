package com.example.ldatatask.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ldatatask.NoteDatabase;
import com.example.ldatatask.R;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewHolder>{

    private final Context context;
    private Cursor cursor;

    private OnClickListenerNote listenerNote;

    public NoteAdapter(Context context, Cursor cursor) {
        this.context = context;
        this.cursor = cursor;
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.note_item,parent, false);

        return new NoteViewHolder(view);
    }

    @Override
    @SuppressLint("Range")
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        if (!cursor.moveToPosition(position)) {
            return;
        }
        String title = cursor.getString(cursor.getColumnIndex(NoteDatabase.title));
        String time = cursor.getString(cursor.getColumnIndex(NoteDatabase.time));
        String description = cursor.getString(cursor.getColumnIndex(NoteDatabase.description));

        long id = cursor.getLong(cursor.getColumnIndex(NoteDatabase.id_note));


        holder.itemView.setTag(id);
        holder.tv_Title.setText(title);
        holder.tv_Time.setText(time);
        holder.tv_Description.setText(description);

    }

    @Override
    public int getItemCount() {
        return cursor.getCount();
    }

    public class NoteViewHolder extends RecyclerView.ViewHolder{

        CardView cvParent;
        private final TextView tv_Title;
        private final TextView tv_Time;
        private final TextView tv_Description;

        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);

            cvParent = itemView.findViewById(R.id.cvParent);

            tv_Title = itemView.findViewById(R.id.tvTitle);
            tv_Time = itemView.findViewById(R.id.tvTime);
            tv_Description = itemView.findViewById(R.id.tvDescription);

            itemView.setOnClickListener(view -> {
                long position = (long) itemView.getTag();
                listenerNote.onItemClickNote(position);
            });

        }
    }

    public interface OnClickListenerNote{
        void onItemClickNote(long id);
    }
    public void setOnClickListenerNote(OnClickListenerNote listenerNote){
        this.listenerNote = listenerNote;
    }

    @SuppressLint("NotifyDataSetChanged")
    public void swapCursor(Cursor newCursor){
        if (cursor != null) {
            cursor.close();
        }
        cursor = newCursor;

        if (newCursor != null) {
            this.notifyDataSetChanged();
        }
    }
}