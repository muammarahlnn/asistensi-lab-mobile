package com.example.backgroundthreadfragment;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.List;

public class ModelDummy implements Parcelable {
    Uri profile;
    private String nickname;
    private String username;
    Uri foto;

    public ModelDummy(Uri profile, String nickname, String username, Uri foto, String caption) {
        this.profile = profile;
        this.nickname = nickname;
        this.username = username;
        this.foto = foto;
        this.caption = caption;
    }

    public Uri getProfile() {
        return profile;
    }

    public void setProfile(Uri profile) {
        this.profile = profile;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Uri getFoto() {
        return foto;
    }

    public void setFoto(Uri foto) {
        this.foto = foto;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    private String caption;


    protected ModelDummy(Parcel in) {
        profile = in.readParcelable(Uri.class.getClassLoader());
        nickname = in.readString();
        username = in.readString();
        foto = in.readParcelable(Uri.class.getClassLoader());
        caption = in.readString();
    }

    public static final Creator<ModelDummy> CREATOR = new Creator<ModelDummy>() {
        @Override
        public ModelDummy createFromParcel(Parcel in) {
            return new ModelDummy(in);
        }

        @Override
        public ModelDummy[] newArray(int size) {
            return new ModelDummy[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeParcelable(profile, i);
        parcel.writeString(nickname);
        parcel.writeString(username);
        parcel.writeParcelable(foto, i);
        parcel.writeString(caption);
    }
}
