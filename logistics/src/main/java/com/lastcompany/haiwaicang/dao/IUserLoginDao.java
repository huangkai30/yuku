package com.lastcompany.haiwaicang.dao;


import com.lastcompany.haiwaicang.entity.SearchObject;
import com.lastcompany.haiwaicang.entity.UserLogin;

import java.util.List;

public interface IUserLoginDao {



    UserLogin getById(int id);



    int add(UserLogin userLogin);
    int update(UserLogin userLogin);
    int delete(int id);

    //rows 表示一页多少行，page表示第几页，sidx进行排列的列名，sord排序的升降序asc、desc
    public SearchObject search(String id, String keyword, int rows, int page, String sidx, String sord);

}
