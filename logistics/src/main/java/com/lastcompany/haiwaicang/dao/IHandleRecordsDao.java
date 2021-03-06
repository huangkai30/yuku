package com.lastcompany.haiwaicang.dao;


import com.lastcompany.haiwaicang.entity.HandleRecords;
import com.lastcompany.haiwaicang.entity.SearchObject;

import java.util.List;

public interface IHandleRecordsDao {



    HandleRecords getById(int id);



    int add(HandleRecords records);
    int update(HandleRecords records);
    int delete(int id);

    //rows 表示一页多少行，page表示第几页，sidx进行排列的列名，sord排序的升降序asc、desc
    public SearchObject search(String id, String keyword, int rows, int page, String sidx, String sord);

}
