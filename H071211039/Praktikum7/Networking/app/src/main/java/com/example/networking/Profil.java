package com.example.networking;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Profil {
    @SerializedName("data")
    private final List<UserResponse> profil;
    public Profil(List<UserResponse> profil) {
        this.profil = profil;
    }

    public List<UserResponse> getProfil() {
        return profil;
    }
}
