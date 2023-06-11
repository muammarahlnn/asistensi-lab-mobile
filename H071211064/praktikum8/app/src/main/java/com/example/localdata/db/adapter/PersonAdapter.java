package com.example.localdata.db.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.localdata.MainActivity;
import com.example.localdata.R;
import com.example.localdata.db.entity.Person;

import java.util.ArrayList;

public class PersonAdapter extends  RecyclerView.Adapter<PersonAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<Person> personList;
    private MainActivity mainActivity;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, title, created_at;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.name = itemView.findViewById(R.id.name);
            this.title = itemView.findViewById(R.id.titlePerson);
            this.created_at = itemView.findViewById(R.id.timestampPerson);
        }

    }

    public PersonAdapter(Context context, ArrayList<Person> personList, MainActivity mainActivity) {
        this.context = context;
        this.personList = personList;
        this.mainActivity = mainActivity;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.person_list_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        final Person person = personList.get(position);
        holder.name.setText(person.getName());
        holder.title.setText(person.getTitle());
        holder.created_at.setText(person.getCreated_at());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivity.addAndEditContacts(true, person, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return personList.size();
    }
}

