package com.example.apinetworking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ArrayList<Datum> results;
    private  Adapter adapter;
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.progressBar);
        GetUser();
    }

    public Object GetUser() {
        progressBar.setVisibility(View.VISIBLE);
        ApiInterface apiInterface = RetrofitInstance.getService();
        Call<Result> call = apiInterface.getUser();
        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                results = new ArrayList<>(response.body().getData());
                //use loop to get all data
                /*for(Datum c : results){
                    Log.i("TAG",""+c.getFirstName()+c.getEmail());
                } */
                ViewData();
                progressBar.setVisibility(View.GONE);


            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                Log.d("TAG", "onFailure: " + t.getMessage());
            }
        });
        return results;

    }
    private void ViewData(){
        recyclerView = findViewById(R.id.recyclerView);
        adapter = new Adapter(results);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}