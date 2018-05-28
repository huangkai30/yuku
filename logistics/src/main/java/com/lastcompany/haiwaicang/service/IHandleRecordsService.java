package com.lastcompany.haiwaicang.service;

import com.lastcompany.haiwaicang.entity.HandleRecords;
import com.lastcompany.haiwaicang.entity.SearchObject;

import java.util.List;
//import com.auctionplatform.constant.Page;
//import com.auctionplatform.entity.House;


public interface IHandleRecordsService {
    public HandleRecords getById(int id);



    public int add(HandleRecords handleRecords);
    public int update(HandleRecords handleRecords);
    public int delete(int id);
    public SearchObject search(String id, String keyword, int rows, int page, String sidx, String sord);

}
