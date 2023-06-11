package com.attar.networkingassignment.data;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {
    @GET("api/users/{id}")
    Call<ReqresInResponse<UserResponse>> getUser(@Path("id") String id);

    @GET("/api/users?page=1")
    Call<ReqresInResponse<List<UserResponse>>> getUsers();
}
