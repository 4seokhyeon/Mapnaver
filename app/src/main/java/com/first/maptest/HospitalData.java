package com.first.maptest;

public class HospitalData {
    public Double getWGS84_LON() {
        return WGS84_LON;
    }

    public void setWGS84_LON(Double WGS84_LON) {
        this.WGS84_LON = WGS84_LON;
    }

    public Double getWGS84_LAT() {
        return WGS84_LAT;
    }

    public void setWGS84_LAT(Double WGS84_LAT) {
        this.WGS84_LAT = WGS84_LAT;
    }

    Double WGS84_LON;
    Double WGS84_LAT;
    String dutyAddr;
    String dutyTel1;

    public String getDutyAddr() {
        return dutyAddr;
    }

    public void setDutyAddr(String dutyAddr) {
        this.dutyAddr = dutyAddr;
    }

    public String getDutyTel1() {
        return dutyTel1;
    }

    public void setDutyTel1(String dutyTel1) {
        this.dutyTel1 = dutyTel1;
    }

    public String getDutyName() {
        return dutyName;
    }

    public void setDutyName(String dutyName) {
        this.dutyName = dutyName;
    }

    String dutyName;


}

