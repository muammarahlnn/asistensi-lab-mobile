package com.pmb.udingram;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

public class UserPostData implements Parcelable {
    Uri imagePost;
    String caption;

    public UserPostData(Uri imagePost, String caption){
        this.imagePost = imagePost;
        this.caption = caption;
    }

    public void setImagePost(Uri imagePost) {
        this.imagePost = imagePost;
    }

    public Uri getImagePost() {
        return imagePost;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getCaption() {
        return caption;
    }

    protected UserPostData(Parcel in) {
        imagePost = in.readParcelable(Uri.class.getClassLoader());
        caption = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(imagePost, flags);
        dest.writeString(caption);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<UserPostData> CREATOR = new Creator<UserPostData>() {
        @Override
        public UserPostData createFromParcel(Parcel in) {
            return new UserPostData(in);
        }

        @Override
        public UserPostData[] newArray(int size) {
            return new UserPostData[size];
        }
    };
}
