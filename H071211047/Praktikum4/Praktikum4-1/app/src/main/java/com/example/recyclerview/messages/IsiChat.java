package com.example.recyclerview.messages;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class IsiChat implements Parcelable {
    String isichat;
    String waktu;

    public IsiChat(String isichat, String waktu) {
        this.isichat = isichat;
        this.waktu = waktu;
    }

    public String getIsichat() {
        return isichat;
    }

    public String getWaktu() {
        return waktu;
    }

    protected IsiChat(Parcel in) {
        isichat = in.readString();
        waktu = in.readString();
    }

    public static final Creator<IsiChat> CREATOR = new Creator<IsiChat>() {
        @Override
        public IsiChat createFromParcel(Parcel in) {
            return new IsiChat(in);
        }

        @Override
        public IsiChat[] newArray(int size) {
            return new IsiChat[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(isichat);
        parcel.writeString(waktu);
    }
}
