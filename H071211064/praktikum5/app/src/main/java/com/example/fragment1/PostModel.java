package com.example.fragment1;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class PostModel implements Parcelable {
     Uri imagePick;
     String captionPost;

    public PostModel(Uri imagePick, String captionPost) {
        this.imagePick = imagePick;
        this.captionPost = captionPost;
    }

    public PostModel(){

    }

    protected PostModel(Parcel in) {
        imagePick = in.readParcelable(Uri.class.getClassLoader());
        captionPost = in.readString();
    }

    public static final Creator<PostModel> CREATOR = new Creator<PostModel>() {
        @Override
        public PostModel createFromParcel(Parcel in) {
            return new PostModel(in);
        }

        @Override
        public PostModel[] newArray(int size) {
            return new PostModel[size];
        }
    };

    public Uri getImagePick() {
        return imagePick;
    }

    public void setImagePick(Uri imagePick) {
        this.imagePick = imagePick;
    }

    public String getCaptionPost() {
        return captionPost;
    }

    public void setCaptionPost(String captionPost) {
        this.captionPost = captionPost;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(captionPost);
        dest.writeParcelable(imagePick, flags);
    }
}
