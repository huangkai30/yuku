package com.lastcompany.haiwaicang.service;

import com.lastcompany.haiwaicang.entity.Product;
import com.lastcompany.haiwaicang.entity.SearchObject;

import java.util.List;
//import com.auctionplatform.constant.Page;
//import com.auctionplatform.entity.House;


public interface IProductService {
    Product getById(int id);
    Product getBySku(String sku);
    Product addInventory(String sku,int inventory);
    Product removeInventory(String sku,int inventory);

    int add(Product product);
    int update(Product product);
    int delete(int id);
    public SearchObject search(String id, String keyword, int rows, int page, String sidx, String sord);

}
