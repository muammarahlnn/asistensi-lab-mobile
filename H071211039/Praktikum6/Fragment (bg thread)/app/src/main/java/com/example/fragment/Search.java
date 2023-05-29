package com.example.fragment;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Search implements Parcelable {
    private String Username, FullName;
    private int Profile;

    public Search() {
    }

    public Search(String username, String fullName, int profile) {
        Username = username;
        FullName = fullName;
        Profile = profile;
    }

    protected Search(Parcel in) {
        Username = in.readString();
        FullName = in.readString();
        Profile = in.readInt();
    }


    public static final Creator<Search> CREATOR = new Creator<Search>() {
        @Override
        public Search createFromParcel(Parcel in) {
            return new Search(in);
        }

        @Override
        public Search[] newArray(int size) {
            return new Search[size];
        }
    };

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public int getProfile() {
        return Profile;
    }

    public void setProfile(int profile) {
        Profile = profile;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(Username);
        parcel.writeString(FullName);
        parcel.writeInt(Profile);
    }
}
