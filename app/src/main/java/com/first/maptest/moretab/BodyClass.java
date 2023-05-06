package com.first.maptest.moretab;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;

@Root(name="body", strict=false)
public
class BodyClass {
    @ElementList(entry = "items")
    ArrayList<ItemClass> items ;
    @Element(name = "numOfRows")
    String numOfRows;
    @Element(name = "pageNo")
    String pageNo;
    @Element(name = "totalCount")
    String totalCount;

    public ArrayList<ItemClass> getItems() {
        return items;
    }

    public void setItems(ArrayList<ItemClass> items) {
        this.items = items;
    }

    public String getNumOfRows() {
        return numOfRows;
    }

    public void setNumOfRows(String numOfRows) {
        this.numOfRows = numOfRows;
    }

    public String getPageNo() {
        return pageNo;
    }

    public void setPageNo(String pageNo) {
        this.pageNo = pageNo;
    }

    public String getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(String totalCount) {
        this.totalCount = totalCount;
    }
}

