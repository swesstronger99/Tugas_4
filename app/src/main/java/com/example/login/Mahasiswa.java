package com.example.login;

import android.os.Parcel;
import android.os.Parcelable;

public class Mahasiswa implements Parcelable {
    private String Username;
    private int Nim;
    private int Umur;
    private String Password;

    public void setUsername(String username) {
        Username = username;
    }

    public void setNim(int nim) {
        Nim = nim;
    }

    public void setUmur(int umur) {
        Umur = umur;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getUsername() {
        return Username;
    }

    public int getNim() {
        return Nim;
    }

    public int getUmur() {
        return Umur;
    }

    public String getPassword() {
        return Password;
    }

    protected Mahasiswa(Parcel in) {
        Username=in.readString();
        Nim=in.readInt();
        Umur=in.readInt();
        Password=in.readString();
    }

    public Mahasiswa(String Username, int Nim, int Umur, String Password){
        this.Username = Username;
        this.Nim = Nim;
        this.Umur = Umur;
        this.Password = Password;
    }

    public static final Creator<Mahasiswa> CREATOR = new Creator<Mahasiswa>() {
        @Override
        public Mahasiswa createFromParcel(Parcel in) {
            return new Mahasiswa(in);
        }

        @Override
        public Mahasiswa[] newArray(int size) {
            return new Mahasiswa[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Username);
        dest.writeInt(Nim);
        dest.writeInt(Umur);
        dest.writeString(Password);
    }
}
