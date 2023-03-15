package com.first.maptest;

public class MnInfo {

    private String name;
    private String age;
    private String bg;

    public MnInfo(String name, String age, String bg){
        this.name = name;
        this.age = age;
        this.bg = bg;
    }

    public String getName() {return name;}

    public void setName(String name){this.name = name;}

    public String getAge() {return age;}

    public void setAge(String age) {this.age = age;}

    public String getBg() {return bg;}

    public void setBg(String bg) {this.bg = bg;}
}
