package com.first.maptest;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

//파이어베이스 클래스임 상엽 클래스
public class Hospital implements Parcelable {
    //private String profile;
    private String addr;   //병원 주소
    private String h_name;
    private String h_type;
    private String h_tell;



    public Hospital(String addr, String h_name, String h_type, String h_tell) {
        this.addr = addr;
        this.h_name = h_name;
        this.h_type = h_type;
        this.h_tell= h_tell;
    }

    public Hospital(){}

   /* public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }*/

    protected Hospital(Parcel in) {
        addr = in.readString();
        h_name = in.readString();
        h_type = in.readString();
        h_tell=in.readString();
    }

    public static final Creator<Hospital> CREATOR = new Creator<Hospital>() {
        @Override
        public Hospital createFromParcel(Parcel in) {
            return new Hospital(in);
        }

        @Override
        public Hospital[] newArray(int size) {
            return new Hospital[size];
        }
    };

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getH_name() {
        return h_name;
    }

    public void setH_name(String h_name) {
        this.h_name = h_name;
    }

    public String getH_tell() {
        return h_tell;
    }

    public void setH_tell(String h_tell) {
        this.h_tell = h_tell;
    }
    public String getH_type() {
        return h_type;
    }

    public void setH_type(String h_type) {
        this.h_type = h_type;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(addr);
        dest.writeString(h_name);
        dest.writeString(h_type);
        dest.writeString(h_tell);
    }
}
