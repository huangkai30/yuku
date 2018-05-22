package com.lastcompany.haiwaicang.service;

import com.lastcompany.haiwaicang.entity.HandleRecords;

import java.util.List;
//import com.auctionplatform.constant.Page;
//import com.auctionplatform.entity.House;


public interface IHandleRecordsService {
    public HandleRecords getById(int id);



    public int add(HandleRecords handleRecords);
    public int update(HandleRecords handleRecords);
    public int delete(int id);
    public List<HandleRecords> search(String id, String keyword, String rows, String page, String sidx, String sord);

}
