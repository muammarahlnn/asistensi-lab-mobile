package com.example.localdata;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Note implements Parcelable {
    private int Id;
    private String Title, Description, Date;

    public Note() {
    }

    public Note(int id, String title, String description, String date) {
        Id = id;
        Title = title;
        Description = description;
        Date = date;
    }

    protected Note(Parcel in) {
        Id = in.readInt();
        Title = in.readString();
        Description = in.readString();
        Date = in.readString();
    }

    public static final Creator<Note> CREATOR = new Creator<Note>() {
        @Override
        public Note createFromParcel(Parcel in) {
            return new Note(in);
        }

        @Override
        public Note[] newArray(int size) {
            return new Note[size];
        }
    };

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(Id);
        parcel.writeString(Title);
        parcel.writeString(Description);
        parcel.writeString(Date);
    }


}
