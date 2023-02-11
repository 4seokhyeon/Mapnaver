package com.first.maptest;

public class mvinfo {
    private String date;
    private String time;

    mvinfo(String date, String time){
        this.date = date;
        this.time = time;
    }

    public String getDate() {return date;}

    public void setDate(String date){this.date = date;}

    public String getTime() {return time;}

    public void setTime(String time) {this.time = time;}
}

