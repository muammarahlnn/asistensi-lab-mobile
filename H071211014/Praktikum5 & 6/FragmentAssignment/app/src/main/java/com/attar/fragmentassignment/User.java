package com.attar.fragmentassignment;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;

public class User implements Parcelable {

    private String fullname, username;

    @DrawableRes
    private int imageRes;
    private Post post;

    public User (){
    }

    public User (String fullname, String username, int imageRes, Post post) {
        this.fullname = fullname;
        this.username = username;
        this.imageRes = imageRes;
        this.post = post;
    }

    protected User (Parcel in) {
        fullname = in.readString();
        username = in.readString();
        imageRes = in.readInt();
        post = in.readParcelable(Post.class.getClassLoader());
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel (Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray (int size) {
            return new User[size];
        }
    };

    public String getFullname () {
        return fullname;
    }

    public void setFullname (String fullname) {
        this.fullname = fullname;
    }

    public String getUsername () {
        return username;
    }

    public void setUsername (String username) {
        this.username = username;
    }

    public int getImageRes () {
        return imageRes;
    }

    public void setImageRes (int imageRes) {
        this.imageRes = imageRes;
    }

    public Post getPost () {
        return post;
    }

    public void setPost (Post post) {
        this.post = post;
    }

    @Override
    public int describeContents () {
        return 0;
    }

    @Override
    public void writeToParcel (@NonNull Parcel parcel, int i) {
        parcel.writeString(fullname);
        parcel.writeString(username);
        parcel.writeInt(imageRes);
        parcel.writeParcelable(post, i);
    }
}
