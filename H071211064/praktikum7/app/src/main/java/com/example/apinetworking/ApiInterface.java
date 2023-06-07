package com.example.apinetworking;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {
    @GET("api/users?page=2")
    //Call every page
    Call<Result> getUser();

    @GET("api/users/{id}")
    Call<ResultProfile> getProfile(@Path("id") String id);

}
