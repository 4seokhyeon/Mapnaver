package com.first.maptest.accompaying;

public class HpInfo {
    private String date;
    private String time;
    private String gender;
    private String age;
    private String ps;

    public HpInfo(String date, String time, String gender, String age, String ps){
        this.date = date;
        this.time = time;
        this.gender = gender;
        this.age = age;
        this.ps = ps;
    }

    public String getDate() {return date;}

    public void setDate(String date){this.date = date;}

    public String getTime() {return time;}

    public void setTime(String time) {this.time = time;}

    public String getGender() {return gender;}

    public void setGender(String gender) {this.gender = gender;}

    public String getAge() {return age;}

    public void setAge(String age) {this.age = age;}

    public String getPs() {return ps;}

    public void setPs(String ps) {this.ps = ps;}
}
