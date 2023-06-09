package com.example.tugasrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ChatDetail extends AppCompatActivity {
    private ImageView imageView;
    private TextView profileName;

    private LinearLayout chatProfile;
    private ImageButton backButton;
    private List<Message> messageList = new ArrayList<>();
    private RecyclerView recyclerView;
    private MessageAdapter messageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_detail);

        chatProfile = findViewById(R.id.chatProfileInclude);
        imageView = findViewById(R.id.imageView);
        profileName = findViewById(R.id.profileName);
        backButton = findViewById(R.id.backButton);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {

            imageView.setImageResource(bundle.getInt("image"));
            profileName.setText(bundle.getString("name"));
            String status = getIntent().getExtras().getString("status");
            String phoneNumber = getIntent().getExtras().getString("phoneNumber");
            String date = getIntent().getExtras().getString("date");

        }


        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChatDetail.this, MainActivity.class);
                startActivity(intent);
            }
        });
        chatProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String status = getIntent().getExtras().getString("status");
                String phoneNumber = getIntent().getExtras().getString("phoneNumber");
                String date = getIntent().getExtras().getString("date");
                Toast.makeText(ChatDetail.this, "Test  " + status + phoneNumber + date, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ChatDetail.this, Profile.class);
                intent.putExtra("image", bundle.getInt("image"));
                intent.putExtra("name", bundle.getString("name"));
                intent.putExtra("status", status);
                intent.putExtra("phoneNumber", phoneNumber);
                intent.putExtra("date", date);
                startActivity(intent);
            }
        });

        recyclerView = findViewById(R.id.recyclerView2);
        int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.spacing);
        recyclerView.addItemDecoration(new SpacesItemDecoration(spacingInPixels));
        messageAdapter = new MessageAdapter(messageList);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setAdapter(messageAdapter);

        messageList.add(new Message("user", "Halo, apa kabar?"));
        messageList.add(new Message("other", "Hai, kabar baik. Bagaimana denganmu?"));
        messageList.add(new Message("user", "Baik juga. Ada yang bisa dibantu?"));
        messageList.add(new Message("other", "Tidak, terima kasih. Hanya ingin bertanya-tanya saja."));
        messageList.add(new Message("user", "Halo, apa kabar?"));
        messageList.add(new Message("other", "Hai, kabar baik. Bagaimana denganmu?"));
        messageList.add(new Message("user", "Baik juga. Ada yang bisa dibantu?"));
        messageList.add(new Message("other", "Tidak, terima kasih. Hanya ingin bertanya-tanya saja."));
        messageList.add(new Message("user", "Halo, apa kabar?"));
        messageList.add(new Message("other", "Hai, kabar baik. Bagaimana denganmu?"));
        messageList.add(new Message("user", "Baik juga. Ada yang bisa dibantu?"));
        messageList.add(new Message("other", "Tidak, terima kasih. Hanya ingin bertanya-tanya saja."));
        messageList.add(new Message("user", "Halo, apa kabar?"));
        messageList.add(new Message("other", "Hai, kabar baik. Bagaimana denganmu?"));
        messageList.add(new Message("user", "Baik juga. Ada yang bisa dibantu?"));
        messageList.add(new Message("other", "Tidak, terima kasih. Hanya ingin bertanya-tanya saja."));

        messageAdapter.notifyDataSetChanged();
    }
    private static class SpacesItemDecoration extends RecyclerView.ItemDecoration {
        private final int mSpace;

        public SpacesItemDecoration(int space) {
            this.mSpace = space;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            outRect.left = mSpace;
            outRect.right = mSpace;
            outRect.bottom = mSpace;

            if (parent.getChildAdapterPosition(view) == 0)
                outRect.top = mSpace;
        }
    }
}