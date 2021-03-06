package com.lastcompany.haiwaicang.dao;


import com.lastcompany.haiwaicang.entity.Product;
import com.lastcompany.haiwaicang.entity.SearchObject;

import java.util.List;

public interface IProductDao {



    Product getById(int id);
    Product getBySku(String sku);


    int add(Product product);
    int update(Product product);
    int delete(int id);

    //rows 表示一页多少行，page表示第几页，sidx进行排列的列名，sord排序的升降序asc、desc
    SearchObject search(String id, String keyword, int rows, int page, String sidx, String sord);

    boolean existsku(String sku);

    Product updateInventory(int id,int inventory);





}
