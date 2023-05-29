package com.example.networking;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class User {
    @SerializedName("data")
    private final List<UserResponse> users;

    public User(List<UserResponse> users) {
        this.users = users;
    }

    public List<UserResponse> getUsers() {
        return users;
    }
}
