package com.example.fragment;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;

public class Home implements Parcelable {
    private String Username, FullName, Caption;
    @DrawableRes
    private int Profile;
    private Uri photoUri;
    public Home(){
    }
    public Home(String username, String fullName, String caption, int profile, Uri photoUri) {
        Username = username;
        FullName = fullName;
        Caption = caption;
        Profile = profile;
        this.photoUri = photoUri;
    }
    protected Home(Parcel in) {
        Username = in.readString();
        FullName = in.readString();
        Caption = in.readString();
        Profile = in.readInt();
        photoUri = in.readParcelable(Uri.class.getClassLoader());
    }

    public static final Creator<Home> CREATOR = new Creator<Home>() {
        @Override
        public Home createFromParcel(Parcel in) {
            return new Home(in);
        }

        @Override
        public Home[] newArray(int size) {
            return new Home[size];
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

    public String getCaption() {
        return Caption;
    }

    public void setCaption(String caption) {
        Caption = caption;
    }

    public int getProfile() {
        return Profile;
    }

    public void setProfile(int profile) {
        Profile = profile;
    }

    public Uri getPhotoUri() {
        return photoUri;
    }

    public void setPhotoUri(Uri photoUri) {
        this.photoUri = photoUri;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(Username);
        parcel.writeString(FullName);
        parcel.writeString(Caption);
        parcel.writeInt(Profile);
        parcel.writeParcelable(photoUri, i);
    }
}
