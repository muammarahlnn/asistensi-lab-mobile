package com.example.networking;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    @GET("api/users/{id}")
    Call<Profil> getUserById (@Path("id") String id);

    @GET("api/users")
    Call<User> getUsers(@Query("per_page") String per_page);
}
