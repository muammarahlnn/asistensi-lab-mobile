package com.example.netwtask;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<UserResponse> usersPage1;
    private List<UserResponse> usersPage2;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        progressBar = findViewById(R.id.progressBar);
        usersPage1 = new ArrayList<>();
        usersPage2 = new ArrayList<>();

        progressBar.setVisibility(View.VISIBLE);

        Call<DataResponse> clientPage1 = ApiConfig.getApiService().getUser(1);
        clientPage1.enqueue(new Callback<DataResponse>() {
            @Override
            public void onResponse(@NonNull Call<DataResponse> call, @NonNull Response<DataResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        usersPage1 = response.body().getData();
                        loadUsers();
                    }
                } else {
                    if (response.body() != null) {
                        Log.e("MainActivity", "onFailure: " + response.message());
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<DataResponse> call, @NonNull Throwable t) {
                Log.e("MainActivity", "onFailure: " + t.getMessage());
            }
        });

        Call<DataResponse> clientPage2 = ApiConfig.getApiService().getUser(2);
        clientPage2.enqueue(new Callback<DataResponse>() {
            @Override
            public void onResponse(@NonNull Call<DataResponse> call, @NonNull Response<DataResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        usersPage2 = response.body().getData();
                        loadUsers();
                    }
                } else {
                    if (response.body() != null) {
                        Log.e("MainActivity", "onFailure: " + response.message());
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<DataResponse> call, @NonNull Throwable t) {
                Log.e("MainActivity", "onFailure: " + t.getMessage());
            }
        });
    }

    private void loadUsers() {
        List<UserResponse> allUsers = new ArrayList<>();
        allUsers.addAll(usersPage1);
        allUsers.addAll(usersPage2);
        UserAdapter userAdapter = new UserAdapter(allUsers, MainActivity.this);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        recyclerView.setAdapter(userAdapter);
        progressBar.setVisibility(View.GONE);
    }
}
