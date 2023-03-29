package com.attar.tugas3;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class User implements Parcelable {

    private String fullname, username;
    private Uri photoUri;
    private Post post;

    public User(){

    }
    protected User(Parcel in) {
        fullname = in.readString();
        username = in.readString();
        photoUri = in.readParcelable(Uri.class.getClassLoader());
        post = in.readParcelable(Post.class.getClassLoader());
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
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

    public Uri getPhotoUri() {
        return photoUri;
    }

    public void setPhotoUri(Uri photoUri) {
        this.photoUri = photoUri;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public User(String fullname, String username, Uri photoUri, Post post) {
        this.fullname = fullname;
        this.username = username;
        this.photoUri = photoUri;
        this.post = post;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(fullname);
        parcel.writeString(username);
        parcel.writeParcelable(photoUri, i);
        parcel.writeParcelable(post, i);
    }
}
