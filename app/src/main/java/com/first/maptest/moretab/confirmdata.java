package com.first.maptest.moretab;

public class confirmdata {

    private String date;
    private String time;
    private String name;
    private String number;
    private String input;
    private String birthday;

    public confirmdata(String date, String time, String name, String number, String input, String birthday){
        this.date = date;
        this.time = time;
        this.name = name;
        this.number = number;
        this.input = input;
        this.birthday = birthday;
    }


    public String getDate() {return date;}

    public void setDate(String date){this.date = date;}

    public String getTime() {return time;}

    public void setTime(String time) {this.time = time;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getNumber() {return number;}

    public void setNumber(String number) {this.number = number;}

    public String getInput() {return input;}

    public void setInput(String input) {this.input = input;}

    public String getBirthday() {return birthday;}

    public void setBirthday(String birthday) {this.birthday = birthday;}


}
