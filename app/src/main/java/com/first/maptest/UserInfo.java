package com.first.maptest;

public class UserInfo {
    private String name;
    private String p_num;
    private String birthday;
    private String addr;

    UserInfo(String name, String p_num, String bityhday, String addr){
        this.name = name;
        this.p_num=p_num;
        this.birthday=bityhday;
        this.addr=addr;
    }

    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getP_num(){
        return this.p_num;
    }
    public void setP_num(String p_num){
        this.p_num=p_num;
    }
    public String getBirthday(){
        return this.birthday;
    }
    public void setBirthday(String birthday){
        this.birthday=birthday;
    }
    public String getAddr(){
        return this.addr;
    }
    public void setAddr(String addr){
        this.addr=addr;
    }

}
