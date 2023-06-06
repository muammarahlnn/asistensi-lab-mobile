package com.example.fragment;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class ModelClass implements Parcelable {
    private String pictureUri;
    private String caption;
    private String profile1;


    public ModelClass(String pictureUri, String caption) {
        this.pictureUri = pictureUri;
        this.caption = caption;
    }

    public static final Creator<ModelClass> CREATOR = new Creator<ModelClass>() {
        @Override
        public ModelClass createFromParcel(Parcel in) {
            return new ModelClass(in);
        }

        @Override
        public ModelClass[] newArray(int size) {
            return new ModelClass[size];
        }
    };

    public ModelClass(Parcel in) {
        pictureUri = in.readString();
        caption = in.readString();
        profile1 = in.readString();
    }

    public String getPictureUri() {
        return pictureUri;
    }

    public String getCaption() {
        return caption;
    }

    public String getProfile1() {
        return profile1;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(pictureUri);
        dest.writeString(caption);
    }
}
