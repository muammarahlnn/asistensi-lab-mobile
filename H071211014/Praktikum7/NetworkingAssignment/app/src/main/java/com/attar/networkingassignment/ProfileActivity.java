package com.attar.networkingassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.widget.TextView;

import com.attar.networkingassignment.data.ApiConfig;
import com.attar.networkingassignment.data.ReqresInResponse;
import com.attar.networkingassignment.data.UserResponse;
import com.bumptech.glide.Glide;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        TextView tvUsername = findViewById(R.id.tv_username);
        TextView tvEmail = findViewById(R.id.tv_email);
        CircleImageView cvImageView = findViewById(R.id.cv_profilePicture);

        int id = getIntent().getIntExtra("id", 0);
        ApiConfig.getApiService().getUser(String.valueOf(id))
                .enqueue(new Callback<ReqresInResponse<UserResponse>>() {
                    @Override
                    public void onResponse (Call<ReqresInResponse<UserResponse>> call, Response<ReqresInResponse<UserResponse>> response) {
                        if(response.isSuccessful()){
                            if(response.body() != null){
                                UserResponse userResponse = response.body().getData();
                                String fullName = userResponse.getFirstName() + " " + userResponse.getLastName();
                                tvUsername.setText(fullName);
                                tvEmail.setText(userResponse.getEmail());
                                Glide.with(ProfileActivity.this).load(userResponse.getAvatarUrl()).into(cvImageView);

                            }
                        }
                    }

                    @Override
                    public void onFailure (Call<ReqresInResponse<UserResponse>> call, Throwable t) {

                    }
                });
    }
}