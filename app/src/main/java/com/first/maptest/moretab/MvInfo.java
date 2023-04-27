package com.first.maptest.moretab;

import android.location.Address;

public class MvInfo {

    private String date;
    private String time;
    private String ad;
    private String name;

    public MvInfo(String date, String time, String ad, String name){
        this.date = date;
        this.time = time;
        this.ad = ad;
        this.name = name;
    }

    public String getDate() {return date;}

    public void setDate(String date){this.date = date;}

    public String getTime() {return time;}

    public void setTime(String time) {this.time = time;}

    public String getAd(){return ad;}

    public void setAd(String ad) {this.ad = ad;}

    public String getName(){return name;}

    public void setName(String name) {this.name = name;}

}
