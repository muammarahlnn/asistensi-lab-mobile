package com.attar.networkingassignment.data;

import com.google.gson.annotations.SerializedName;

public class ReqresInResponse<T> {

    @SerializedName("data")
    private T data;

    public T getData() {
        return data;
    }

}
