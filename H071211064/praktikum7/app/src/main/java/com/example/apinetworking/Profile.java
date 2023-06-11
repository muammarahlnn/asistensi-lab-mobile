package com.example.apinetworking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Profile extends AppCompatActivity {
    private TextView tvName, tvEmail, tvLastName;
    private String name, email, lastName, avatarUrl;
    private ImageView imageView;
    private Datum results;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        InitiateViews();
        int id = getIntent().getIntExtra("id", 0);


        GetProfile(String.valueOf(id));

    }

    private void InitiateViews() {
        tvName = findViewById(R.id.tvName);
        tvEmail = findViewById(R.id.tvEmail);
        tvLastName = findViewById(R.id.tvLastName);
        progressBar = findViewById(R.id.progressBar);
        imageView = findViewById(R.id.avatar);

    }

    public Object GetProfile(String id) {
        progressBar.setVisibility(View.VISIBLE);
        ApiInterface apiInterface = RetrofitInstance.getService();
        Call<ResultProfile> call = apiInterface.getProfile(id);
        call.enqueue(new Callback<ResultProfile>() {
            @Override
            public void onResponse(Call<ResultProfile> call, Response<ResultProfile> response) {
                results = response.body().getData();
                name = results.getFirstName();
                email = results.getEmail();
                lastName = results.getLastName();
                avatarUrl = results.getAvatar();
                tvName.setText(name);
                tvEmail.setText(email);
                tvLastName.setText(lastName);
                Picasso.get().load(avatarUrl).into(imageView);

                // hide loading
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<ResultProfile> call, Throwable t) {

            }
        });
        return results;
    }
}