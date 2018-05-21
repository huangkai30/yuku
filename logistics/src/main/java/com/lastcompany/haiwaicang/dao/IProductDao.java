package com.lastcompany.haiwaicang.dao;


import com.lastcompany.haiwaicang.entity.Product;

import java.util.List;

public interface IProductDao {



    Product getById(int id);



    int add(Product product);
    int update(Product product);
    int delete(int id);

    //rows 表示一页多少行，page表示第几页，sidx进行排列的列名，sord排序的升降序asc、desc
    public List<Product> search(String id, String keyword, String rows, String page, String sidx, String sord);

}
