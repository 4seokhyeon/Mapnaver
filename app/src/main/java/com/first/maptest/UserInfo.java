package com.first.maptest;

public class UserInfo {
    private String name;
    private String p_num;
    private String birthday;
    private String addr;

    UserInfo(String name, String p_num, String birthday, String addr){
        this.name=name;
        this.p_num=p_num;
        this.birthday=birthday;
        this.addr=addr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getP_num() {
        return p_num;
    }

    public void setP_num(String p_num) {
        this.p_num = p_num;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
}
