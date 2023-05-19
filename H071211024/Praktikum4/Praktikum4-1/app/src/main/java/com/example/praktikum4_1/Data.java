package com.example.praktikum4_1;

import android.os.Parcel;
import android.os.Parcelable;

public class Data implements Parcelable {
 private String name;
 private String detail;
 private String number;
 private String status;
 private int photo;

 public Data() {

 }
 public String getNumber() {
  return number;
 }
 public void setNumber(String number) {
  this.number = number;
 }

 public String getName() {
  return name;
 }

 public void setName(String name) {
  this.name = name;
 }

 public String getDetail() {
  return detail;
 }

 public void setDetail(String detail) {
  this.detail = detail;
 }

 public String getStatus() {
  return status;
 }

 public void setStatus(String status) {
  this.status = status;
 }


 public int getPhoto() {
  return photo;
 }

 public void setPhoto(int photo) {
  this.photo = photo;
 }

 protected Data(Parcel in) {
  name = in.readString();
  detail = in.readString();
  number = in.readString();
  status = in.readString();
  photo = in.readInt();
 }

 public static final Creator<Data> CREATOR = new Creator<Data>() {
  @Override
  public Data createFromParcel(Parcel in) {
   return new Data(in);
  }

  @Override
  public Data[] newArray(int size) {
   return new Data[size];
  }
 };

 @Override
 public int describeContents() {
  return 0;
 }

 @Override
 public void writeToParcel(Parcel dest, int flags) {
  dest.writeString(name);
  dest.writeString(detail);
  dest.writeString(number);
  dest.writeString(status);
  dest.writeInt(photo);
 }
}


