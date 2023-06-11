package com.example.apinetworking;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResultProfile {

    @SerializedName("data")
    @Expose
    private Datum data;

    public Datum getData() {
        return data;
    }
}
