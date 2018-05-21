package com.lastcompany.haiwaicang.service;

import com.lastcompany.haiwaicang.entity.User;
import com.lastcompany.haiwaicang.entity.UserLogin;

import java.util.List;
//import com.auctionplatform.constant.Page;
//import com.auctionplatform.entity.House;


public interface IUserLoginService {
    UserLogin getById(int id);



    int add(UserLogin userLogin);
    int update(UserLogin userLogin);
    int delete(int id);
    public List<UserLogin> search(String id, String keyword, String rows, String page, String sidx, String sord);

}
