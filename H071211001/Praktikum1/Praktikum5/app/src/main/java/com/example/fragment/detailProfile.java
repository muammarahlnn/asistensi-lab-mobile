package com.example.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class detailProfile extends Activity {

    private ImageView Profile;
    private TextView Nama1, Nama2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_profile);

        Profile = findViewById(R.id.seeprofile);
        Nama1 = findViewById(R.id.Nama1);
        Nama2 = findViewById(R.id.Nama2);
    }
}
