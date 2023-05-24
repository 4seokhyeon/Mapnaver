package com.first.maptest;

import com.first.maptest.moretab.BodyClass;
import com.first.maptest.moretab.HeaderClass;
import com.first.maptest.moretab.ItemClass;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name="response", strict = false)
public class HospitalData {
    public ItemClass itemClass;
    @Element(name="header")
    HeaderClass headerClass;
    @Element(name="body")
    BodyClass bodyClass ;


    public HeaderClass getHeaderClass() {
        return headerClass;
    }

    public void setHeaderClass(HeaderClass headerClass) {
        this.headerClass = headerClass;
    }

    public BodyClass getBodyClass() {
        return bodyClass;
    }

    public void setBodyClass(BodyClass bodyClass) {
        this.bodyClass = bodyClass;
    }


}
