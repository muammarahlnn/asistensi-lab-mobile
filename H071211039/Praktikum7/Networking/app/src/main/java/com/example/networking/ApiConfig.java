package com.example.networking;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiConfig {
    public static com.example.networking.ApiService getApiService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://reqres.in")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        com.example.networking.ApiService apiService = retrofit.create(com.example.networking.ApiService.class);

        return apiService;
    }
}
