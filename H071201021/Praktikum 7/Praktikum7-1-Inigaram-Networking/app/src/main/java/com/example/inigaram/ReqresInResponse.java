package com.example.inigaram;

import com.google.gson.annotations.SerializedName;

public class ReqresInResponse<T> {
    @SerializedName("data")
    private T data;

    public T getData() {
        return this.data;
    }
}
