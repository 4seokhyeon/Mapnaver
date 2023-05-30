package com.first.maptest.moretab;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name="header", strict=false)
public
class HeaderClass {
    @Element(name="resultMsg")
    String resultMsg;
    @Element(name="resultCode")
    String resultCode;

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }//
}