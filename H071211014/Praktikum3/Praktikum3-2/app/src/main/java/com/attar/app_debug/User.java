package com.attar.app_debug;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class User implements Parcelable {

    private String name;
    private int currentScore,bestScore;
    private Uri fotoUri;

    public User(){
    }

    public User(String name, int currentScore, int bestScore, Uri fotoUri) {
        this.name = name;
        this.currentScore = currentScore;
        this.bestScore = bestScore;
        this.fotoUri = fotoUri;
    }

    protected User(Parcel in) {
        name = in.readString();
        currentScore = in.readInt();
        bestScore = in.readInt();
        fotoUri = in.readParcelable(Uri.class.getClassLoader());
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCurrentScore() {
        return currentScore;
    }

    public void setCurrentScore(int currentScore) {
        this.currentScore = currentScore;
    }

    public int getBestScore() {
        return bestScore;
    }

    public void setBestScore(int bestScore) {
        this.bestScore = bestScore;
    }

    public Uri getFotoUri() {
        return fotoUri;
    }

    public void setFotoUri(Uri fotoUri) {
        this.fotoUri = fotoUri;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeInt(currentScore);
        parcel.writeInt(bestScore);
        parcel.writeParcelable(fotoUri, i);
    }
}
