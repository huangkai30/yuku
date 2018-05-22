package com.lastcompany.haiwaicang.service;

import com.lastcompany.haiwaicang.entity.Product;

import java.util.List;
//import com.auctionplatform.constant.Page;
//import com.auctionplatform.entity.House;


public interface IProductService {
    Product getById(int id);



    int add(Product product);
    int update(Product product);
    int delete(int id);
    public List<Product> search(String id, String keyword, String rows, String page, String sidx, String sord);

}
