package com.lastcompany.haiwaicang.service;

import com.lastcompany.haiwaicang.entity.*;

import java.util.List;
//import com.auctionplatform.constant.Page;
//import com.auctionplatform.entity.House;


public interface IUserService {
    User login(String userName, String password);

    User resetpw(int id,String old_password, String password);


    User getById(int id);



    int add(User user);
    int update(User user);
    int delete(int id);
    public List<User> search(String id, String keyword, String rows, String page, String sidx, String sord);
}
