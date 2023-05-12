package com.example.inigaram;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Post implements Parcelable{
    private String fullname;
    private String username;
    private String postPicture;
    private String postText;
    private String postProfile;


    protected Post(Parcel in) {
        fullname = in.readString();
        username = in.readString();
        postPicture = in.readString();
        postText = in.readString();
    }

    public static final Parcelable.Creator<Post> CREATOR = new Parcelable.Creator<Post>() {
        @Override
        public Post createFromParcel(Parcel in) {
            return new Post(in);
        }

        @Override
        public Post[] newArray(int size) {
            return new Post[size];
        }
    };

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getPostPicture() {
        return postPicture;
    }

    public void setPostPicture(String postPicture) {
        this.postPicture = postPicture;
    }

    public String getPostText() {
        return postText;
    }

    public void getPostText(String postText) {
        this.postText = postText;
    }

    public String getPostProfile() {
        return postProfile;
    }

    public void setPostProfile(String postProfile) {
        this.postProfile = postProfile;
    }
    public Post(String fullname, String username, String postPicture, String postText, String postProfile) {
        this.fullname = fullname;
        this.username = username;
        this.postPicture = postPicture;
        this.postText = postText;
        this.postProfile = postProfile;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(fullname);
        parcel.writeString(username);
        parcel.writeString(postPicture);
        parcel.writeString(postText);
        parcel.writeString(postProfile);
    }
}
