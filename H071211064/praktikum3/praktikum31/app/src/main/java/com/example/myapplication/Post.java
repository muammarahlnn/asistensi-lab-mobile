package com.example.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

public class Post implements Parcelable {
    private String caption;

    public Post(String caption){
        this.caption = caption;
    }
    protected Post(Parcel in) {
        caption = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(caption);
    }

    public void setCaption(String caption){
        this.caption = caption;
    }
    public String getCaption(){
        return caption;
    }

    @Override
    public int describeContents() {
        return 0;
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
}
