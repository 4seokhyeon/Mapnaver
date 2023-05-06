package com.first.maptest;

import com.first.maptest.moretab.BodyClass;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import io.grpc.okhttp.internal.framed.Header;

@Root(name="response", strict = false)
public class HospitalData {
    @Element(name="header")
    Header headerClass;
    @Element(name="body")
    BodyClass bodyClass ;


    public Header getHeaderClass() {
        return headerClass;
    }

    public void setHeaderClass(Header headerClass) {
        this.headerClass = headerClass;
    }

    public BodyClass getBodyClass() {
        return bodyClass;
    }

    public void setBodyClass(BodyClass bodyClass) {
        this.bodyClass = bodyClass;
    }


}
