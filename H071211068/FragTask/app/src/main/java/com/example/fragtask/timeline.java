package com.example.fragtask;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class timeline implements Parcelable {

    private Uri imageUrl;
    private String Capt;

    public timeline(Uri imageUrl, String capt) {
        this.imageUrl = imageUrl;
        Capt = capt;
    }

    protected timeline(Parcel in) {
        imageUrl = in.readParcelable(Uri.class.getClassLoader());
        Capt = in.readString();
    }

    public static final Creator<timeline> CREATOR = new Creator<timeline>() {
        @Override
        public timeline createFromParcel(Parcel in) {
            return new timeline(in);
        }

        @Override
        public timeline[] newArray(int size) {
            return new timeline[size];
        }
    };

    public Uri getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(Uri imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getCapt() {
        return Capt;
    }

    public void setCapt(String capt) {
        Capt = capt;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeParcelable(imageUrl, i);
        parcel.writeString(Capt);
    }
}
