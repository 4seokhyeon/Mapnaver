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
    int numOfRows;
    @Element(name = "pageNo")
    int pageNo;
    @Element(name = "totalCount")
    int totalCount;

    public ArrayList<ItemClass> getItems() {
        return items;
    }

    public void setItems(ArrayList<ItemClass> items) {
        this.items = items;
    }

    public int getNumOfRows() {
        return numOfRows;
    }

    public void setNumOfRows(int numOfRows) {
        this.numOfRows = numOfRows;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }//
}

