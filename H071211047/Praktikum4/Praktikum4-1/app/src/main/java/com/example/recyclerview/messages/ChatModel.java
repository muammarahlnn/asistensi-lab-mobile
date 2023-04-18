package com.example.recyclerview.messages;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class ChatModel implements Parcelable {
    public String nama;
    public String foto;
    public String nohp;
    public String bio;
    public String tanggal;
    public String waktu;
    public String chat;

    public ChatModel(String nama, String foto, String nohp, String bio, String tanggal, String waktu, String chat) {
        this.nama = nama;
        this.foto = foto;
        this.nohp = nohp;
        this.bio = bio;
        this.tanggal = tanggal;
        this.waktu = waktu;
        this.chat = chat;
    }

    public String getNama() {
        return nama;
    }

    public String getFoto() {
        return foto;
    }

    public String getNohp() {
        return nohp;
    }

    public String getBio() {
        return bio;
    }

    public String getTanggal() {
        return tanggal;
    }

    public String getWaktu() {
        return waktu;
    }

    public String getChat() {
        return chat;
    }

    protected ChatModel(Parcel in) {
        nama = in.readString();
        foto = in.readString();
        nohp = in.readString();
        bio = in.readString();
        tanggal = in.readString();
        waktu = in.readString();
        chat = in.readString();
    }

    public static final Creator<ChatModel> CREATOR = new Creator<ChatModel>() {
        @Override
        public ChatModel createFromParcel(Parcel in) {
            return new ChatModel(in);
        }

        @Override
        public ChatModel[] newArray(int size) {
            return new ChatModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(nama);
        parcel.writeString(foto);
        parcel.writeString(nohp);
        parcel.writeString(bio);
        parcel.writeString(tanggal);
        parcel.writeString(waktu);
        parcel.writeString(chat);
    }
}
