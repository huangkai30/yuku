package com.lastcompany.haiwaicang.service;

import com.lastcompany.haiwaicang.entity.SearchObject;
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
    public SearchObject search(String id, String keyword, int rows, int page, String sidx, String sord);

}
