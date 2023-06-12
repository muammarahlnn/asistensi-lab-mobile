package com.example.inigaram;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    @GET("api/users/{id}")
    Call<UserResponse> getUser(@Path("id") String str);

    @GET("api/users")
    Call<DataResponse> getUsers(@Query("per_page") String str);
}