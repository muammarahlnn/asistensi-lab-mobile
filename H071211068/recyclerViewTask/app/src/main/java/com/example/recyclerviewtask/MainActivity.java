package com.example.recyclerviewtask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    List<ModelClass>userlist;
    Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        initRecyclerView();

    }

    private void initData() {
        userlist = new ArrayList<>();
        userlist.add(new ModelClass(R.drawable._681483842180,"Kucing Rajin Sholat","22:10 PM","gasskan"));
        userlist.add(new ModelClass(R.drawable._681483842190,"Kucing Malas","09:11 AM","Ayo aja gue mah"));
        userlist.add(new ModelClass(R.drawable._681483842204,"Bocchi","13:10 PM","pala lo sini gw genjreng"));
        userlist.add(new ModelClass(R.drawable._681483842218,"Temannya Bocchi","16:10 PM","pinjam dulu 100"));
        userlist.add(new ModelClass(R.drawable._681483842230,"Temannya Bocchi juga","12:04 PM","Y in aja Gw Mah"));
        userlist.add(new ModelClass(R.drawable._681483842243,"Digidaw","10:11 AM","ywdh sihn"));
        userlist.add(new ModelClass(R.drawable._681483842260,"Tom ange","18:13 PM","pakai nanya"));
        userlist.add(new ModelClass(R.drawable._681483842272,"Squidwork","19:15 PM","njir"));
        userlist.add(new ModelClass(R.drawable._681483842285,"Elang Kecewa","11:13 AM","oiiiiiiiiiiiiiiiiiiiiiiiiiiiii"));
        userlist.add(new ModelClass(R.drawable._681483842299,"Kaori","12:10 PM","utiwi"));
    }

    private void initRecyclerView() {
        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new Adapter(this,userlist);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }
}