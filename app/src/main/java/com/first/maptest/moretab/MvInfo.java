package com.first.maptest.moretab;

import android.location.Address;

public class MvInfo {

    private String date;
    private String time;
    private String address;

    public MvInfo(String date, String time, String address){
        this.date = date;
        this.time = time;
        this.address = address;
    }

    public String getDate() {return date;}

    public void setDate(String date){this.date = date;}

    public String getTime() {return time;}

    public void setTime(String time) {this.time = time;}

    public String getAddress(){return address;}

    public void setAddress(String address) {this.address = address;}

}
