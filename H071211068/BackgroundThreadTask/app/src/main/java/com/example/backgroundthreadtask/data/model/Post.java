package com.example.backgroundthreadtask.data.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Post implements Parcelable {
   public String caption;
    public Uri img_post;

    public Post(String caption, Uri img_post) {
        this.caption = caption;
        this.img_post = img_post;
    }

    public Post() {
    }

    protected Post(Parcel in) {
        caption = in.readString();
        img_post = in.readParcelable(Uri.class.getClassLoader());
    }

    public static final Creator<Post> CREATOR = new Creator<Post>() {
        @Override
        public Post createFromParcel(Parcel in) {
            return new Post(in);
        }

        @Override
        public Post[] newArray(int size) {
            return new Post[size];
        }
    };

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public Uri getImg_post() {
        return img_post;
    }

    public void setImg_post(Uri img_post) {
        this.img_post = img_post;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(caption);
        parcel.writeParcelable(img_post, i);
    }
}
