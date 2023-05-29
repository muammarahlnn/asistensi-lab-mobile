package com.example.networking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rv;
    private ProgressBar progressBar;
    private AdapterView adapterView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = findViewById(R.id.rv);
        progressBar = findViewById(R.id.progress_Bar);
        adapterView = new AdapterView();

        // show loading
        progressBar.setVisibility(View.VISIBLE);
        rv.setVisibility(View.GONE);
        ApiConfig.getApiService().getUsers("12").enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful() && response.body() != null){

                    adapterView.addUser(response.body().getUsers());
                    rv.setAdapter(adapterView);
                    rv.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    // hide loading
                    progressBar.setVisibility(View.GONE);
                    rv.setVisibility(View.VISIBLE);
                    Log.d("users", response.body().toString());

                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(MainActivity.this, "OnFailure " + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                // hide loading
                progressBar.setVisibility(View.GONE);
                rv.setVisibility(View.VISIBLE);
            }
        });
    }
}