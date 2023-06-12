package com.example.inigaram;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;


public class Post extends Profile implements Parcelable {

    private String postPicture;
    private String postText;


    protected Post(Parcel in) {
        super(in);
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


    public Post(String fullname, String username, String profilePicture, String postText, String postPicture) {
        super(fullname, username, profilePicture);
        this.postPicture = postPicture;
        this.postText = postText;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(postPicture);
        parcel.writeString(postText);
    }
}
