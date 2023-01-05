package com.first.maptest;
//파이어베이스 클래스임 상엽 클래스
public class Hospital {
    private String profile;
    private String addr;
    private String h_name;
    private String h_type;

    public Hospital(){}

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

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

    public String getH_type() {
        return h_type;
    }

    public void setH_type(String h_type) {
        this.h_type = h_type;
    }
}
