package com.attar.networkingassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.attar.networkingassignment.data.ApiConfig;
import com.attar.networkingassignment.data.ReqresInResponse;
import com.attar.networkingassignment.data.UserResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private Adapter adapter;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rvUser = findViewById(R.id.rv_user);
        adapter = new Adapter();
        Call<ReqresInResponse<List<UserResponse>>> client = ApiConfig.getApiService().getUsers();
        client.enqueue(new Callback<ReqresInResponse<List<UserResponse>>>() {
            @Override
            public void onResponse (Call<ReqresInResponse<List<UserResponse>>> call, Response<ReqresInResponse<List<UserResponse>>> response) {
                if(response.isSuccessful()){
                    if(response.body() != null){
                        List<UserResponse> users = response.body().getData();
                        adapter.setUsers(users);
                        rvUser.setAdapter(adapter);
                        rvUser.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    }
                }
            }

            @Override
            public void onFailure (Call<ReqresInResponse<List<UserResponse>>> call, Throwable t) {

            }
        });
    }
}