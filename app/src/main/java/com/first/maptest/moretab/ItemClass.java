package com.first.maptest.moretab;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name="item", strict=false)
public class ItemClass {
    @Element(name="cmdcResdntCnt")
    String cmdcResdntCnt;
    @Element(name="cmdcSdrCnt")
    String cmdcSdrCnt;
    @Element(name="pnursCnt")
    String pnursCnt;
    @Element(name="XPos")
    String XPos;
    @Element(name="YPos")
    String YPos;
    @Element(name="distance")
    String distance;
    @Element(name="detyGdrCnt")
    String detyGdrCnt;
    @Element(name="detyIntnCnt")
    String detyIntnCnt;
    @Element(name="detyResdntCnt")
    String detyResdntCnt;
    @Element(name="detySdrCnt")
    String detySdrCnt;
    @Element(name="cmdcGdrCnt")
    String cmdcGdrCnt;
    @Element(name="cmdcIntnCnt")
    String cmdcIntnCnt;
    @Element(name="mdeptResdntCnt")
    String mdeptResdntCnt;
    @Element(name="drTotCnt")
    String drTotCnt;
    @Element(name="mdeptGdrCnt")
    String mdeptGdrCnt;
    @Element(name="mdeptIntnCnt")
    String mdeptIntnCnt;
    @Element(name="telno",required = false)
    String telno;
    @Element(name="hospUrl",required = false)
    String hospUrl;
    @Element(name="estbDd")
    String estbDd;
    @Element(name="sgguCdNm")
    String sgguCdNm;
    @Element(name="emdongNm",required = false)
    String emdongNm;
    @Element(name="postNo")
    String postNo;
    @Element(name="addr")
    String addr;
    @Element(name="sidoCdNm")
    String sidoCdNm;
    @Element(name="sgguCd")
    int sgguCd;
    @Element(name="ykiho")
    String ykiho;
    @Element(name="yadmNm")
    String yadmNm;
    @Element(name="clCd")
    String clCd;
    @Element(name="clCdNm")
    String clCdNm;
    @Element(name="sidoCd")
    int sidoCd;
    @Element(name="mdeptSdrCnt")
    String mdeptSdrCnt;

    public String getAddr() {
        return addr;
    }

    public String getCmdcResdntCnt() {
        return cmdcResdntCnt;
    }

    public void setCmdcResdntCnt(String cmdcResdntCnt) {
        this.cmdcResdntCnt = cmdcResdntCnt;
    }

    public String getCmdcSdrCnt() {
        return cmdcSdrCnt;
    }

    public void setCmdcSdrCnt(String cmdcSdrCnt) {
        this.cmdcSdrCnt = cmdcSdrCnt;
    }

    public String getPnursCnt() {
        return pnursCnt;
    }

    public void setPnursCnt(String pnursCnt) {
        this.pnursCnt = pnursCnt;
    }

    public String getXPos() {
        return XPos;
    }

    public void setXPos(String XPos) {
        this.XPos = XPos;
    }

    public String getYPos() {
        return YPos;
    }

    public void setYPos(String YPos) {
        this.YPos = YPos;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getDetyGdrCnt() {
        return detyGdrCnt;
    }

    public void setDetyGdrCnt(String detyGdrCnt) {
        this.detyGdrCnt = detyGdrCnt;
    }

    public String getDetyIntnCnt() {
        return detyIntnCnt;
    }

    public void setDetyIntnCnt(String detyIntnCnt) {
        this.detyIntnCnt = detyIntnCnt;
    }

    public String getDetyResdntCnt() {
        return detyResdntCnt;
    }

    public void setDetyResdntCnt(String detyResdntCnt) {
        this.detyResdntCnt = detyResdntCnt;
    }

    public String getDetySdrCnt() {
        return detySdrCnt;
    }

    public void setDetySdrCnt(String detySdrCnt) {
        this.detySdrCnt = detySdrCnt;
    }

    public String getCmdcGdrCnt() {
        return cmdcGdrCnt;
    }

    public void setCmdcGdrCnt(String cmdcGdrCnt) {
        this.cmdcGdrCnt = cmdcGdrCnt;
    }

    public String getCmdcIntnCnt() {
        return cmdcIntnCnt;
    }

    public void setCmdcIntnCnt(String cmdcIntnCnt) {
        this.cmdcIntnCnt = cmdcIntnCnt;
    }

    public String getMdeptResdntCnt() {
        return mdeptResdntCnt;
    }

    public void setMdeptResdntCnt(String mdeptResdntCnt) {
        this.mdeptResdntCnt = mdeptResdntCnt;
    }

    public String getDrTotCnt() {
        return drTotCnt;
    }

    public void setDrTotCnt(String drTotCnt) {
        this.drTotCnt = drTotCnt;
    }

    public String getMdeptGdrCnt() {
        return mdeptGdrCnt;
    }

    public void setMdeptGdrCnt(String mdeptGdrCnt) {
        this.mdeptGdrCnt = mdeptGdrCnt;
    }

    public String getMdeptIntnCnt() {
        return mdeptIntnCnt;
    }

    public void setMdeptIntnCnt(String mdeptIntnCnt) {
        this.mdeptIntnCnt = mdeptIntnCnt;
    }

    public String getTelno() {
        return telno;
    }

    public void setTelno(String telno) {
        this.telno = telno;
    }

    public String getHospUrl() {
        return hospUrl;
    }

    public void setHospUrl(String hospUrl) {
        this.hospUrl = hospUrl;
    }

    public String getEstbDd() {
        return estbDd;
    }

    public void setEstbDd(String estbDd) {
        this.estbDd = estbDd;
    }


    public String getEmdongNm() {
        return emdongNm;
    }

    public void setEmdongNm(String emdongNm) {
        this.emdongNm = emdongNm;
    }

    public String getPostNo() {
        return postNo;
    }

    public void setPostNo(String postNo) {
        this.postNo = postNo;
    }
    
    public void setAddr(String addr) {this.addr = addr;}

    public String getYkiho() {
        return ykiho;
    }

    public void setYkiho(String ykiho) {
        this.ykiho = ykiho;
    }

    public String getYadmNm() {
        return yadmNm;
    }

    public void setYadmNm(String yadmNm) {
        this.yadmNm = yadmNm;
    }

    public String getClCd() {
        return clCd;
    }

    public void setClCd(String clCd) {
        this.clCd = clCd;
    }

    public String getClCdNm() {
        return clCdNm;
    }

    public void setClCdNm(String clCdNm) {
        this.clCdNm = clCdNm;
    }

    public String getMdeptSdrCnt() {
        return mdeptSdrCnt;
    }

    public void setMdeptSdrCnt(String mdeptSdrCnt) {
        this.mdeptSdrCnt = mdeptSdrCnt;
    }

    public int getSgguCd() {
        return sgguCd;
    }

    public void setSgguCd(int sgguCd) {
        this.sgguCd = sgguCd;
    }

    public int getSidoCd() {
        return sidoCd;
    }

    public void setSidoCd(int sidoCd) {
        this.sidoCd = sidoCd;
    }

    public String getSgguCdNm() {
        return sgguCdNm;
    }

    public void setSgguCdNm(String sgguCdNm) {
        this.sgguCdNm = sgguCdNm;
    }

    public String getSidoCdNm() {
        return sidoCdNm;
    }

    public void setSidoCdNm(String sidoCdNm) {
        this.sidoCdNm = sidoCdNm;
    }
}//
