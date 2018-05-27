package com.lastcompany.haiwaicang.entity;


//import org.springframework.data.annotation.CreatedDate;
//import org.springframework.data.annotation.LastModifiedDate;
//
//import javax.persistence.*;
import java.io.Serializable;
//import java.util.Date;
import java.util.List;


public class SearchObject implements Serializable {

      Object data;
      int totalnum;//总数量
      int totalpage;//总页数
      int curpage;//当前页数
      int currows;//返回的实际行数
      int request_rows;//请求每页的数量


    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getTotalnum() {
        return totalnum;
    }

    public void setTotalnum(int totalnum) {
        this.totalnum = totalnum;
    }

    public int getTotalpage() {
        return totalpage;
    }

    public void setTotalpage(int totalpage) {
        this.totalpage = totalpage;
    }

    public int getCurpage() {
        return curpage;
    }

    public void setCurpage(int curpage) {
        this.curpage = curpage;
    }

    public int getCurrows() {
        return currows;
    }

    public void setCurrows(int currows) {
        this.currows = currows;
    }

    public int getRequest_rows() {
        return request_rows;
    }

    public void setRequest_rows(int request_rows) {
        this.request_rows = request_rows;
    }
}