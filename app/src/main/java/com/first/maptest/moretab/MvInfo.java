package com.first.maptest.moretab;

import android.location.Address;

public class MvInfo {

    private String date;
    private String time;
    private String ad;

    public MvInfo(String date, String time, String ad){
        this.date = date;
        this.time = time;
        this.ad = ad;
    }

    public String getDate() {return date;}

    public void setDate(String date){this.date = date;}

    public String getTime() {return time;}

    public void setTime(String time) {this.time = time;}

    public String getAd(){return ad;}

    public void setAd(String ad) {this.ad = ad;}

}
