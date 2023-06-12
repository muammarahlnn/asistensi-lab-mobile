package com.example.whatsapp_ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ChatsActivity extends AppCompatActivity {
    private TextView tv_username;
    private CircleImageView civ_image;
    private ImageView back_button;

    private RecyclerView recyclerViewChats;
    private RecyclerViewAdapterChats adapterChats;
    private List<MyData> chatData = new ArrayList<>();
    private LinearLayout topAppBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chats);
        tv_username = findViewById(R.id.username);
        civ_image = findViewById(R.id.user_image);
        topAppBar = findViewById(R.id.app_bar_layout);
        back_button = findViewById(R.id.back_button);

        Intent terima = getIntent();
        String name = terima.getStringExtra("name");
        tv_username.setText(name);
        int drawableId = terima.getIntExtra("drawable_id", 0);
        civ_image.setImageResource(drawableId);
        ArrayList<MyChats> chatData = (ArrayList<MyChats>) getIntent().getSerializableExtra("chats");
        recyclerViewChats = findViewById(R.id.recycler_view_chats_bubble);
        adapterChats = new RecyclerViewAdapterChats();

        // Set the LayoutManager for the RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerViewChats.setLayoutManager(layoutManager);

        // Set the Adapter for the RecyclerView
        recyclerViewChats.setAdapter(adapterChats);

        // Populate the Adapter with data
        adapterChats.setData(chatData);

        String noTelp = terima.getStringExtra("noTelp");
        String status = terima.getStringExtra("status");
        String statusDate = terima.getStringExtra("statusDate");

        topAppBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // access the name variable of MyData using myData.getName()
                Intent kirim = new Intent(ChatsActivity.this, UserStatusActivity.class);

                kirim.putExtra("name", name);
                kirim.putExtra("drawable_id", drawableId);
                kirim.putExtra("no_telp", noTelp);
                kirim.putExtra("status", status);
                kirim.putExtra("statusDate", statusDate);

                startActivity(kirim);
            }
        });

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // access the name variable of MyData using myData.getName()
                finish();
            }
        });
    }

}
