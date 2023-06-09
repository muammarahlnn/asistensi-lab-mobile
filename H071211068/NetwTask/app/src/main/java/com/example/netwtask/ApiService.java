package com.example.netwtask;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("api/users")
    Call<DataResponse> getUser(@Query("page")int page);
}