package com.lastcompany.haiwaicang.service.impl;

import com.lastcompany.haiwaicang.constant.ErrorMessage;
import com.lastcompany.haiwaicang.constant.ErrorMessageException;
import com.lastcompany.haiwaicang.dao.IProductDao;
import com.lastcompany.haiwaicang.dao.IUserLoginDao;
import com.lastcompany.haiwaicang.entity.Product;
import com.lastcompany.haiwaicang.entity.UserLogin;
import com.lastcompany.haiwaicang.service.IProductService;
//import com.lastcompany.haiwaicang.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
//@Transactional(readOnly = true)
public class ProductService implements IProductService {

    @Autowired
    private IProductDao productDao;

   public Product getById(int id)
    {
      return  productDao.getById(id);
    }



    public int add(Product product)
    {
        int i=productDao.add(product);
        if(i>0)
        {
            return i;
        }
        else
        {
            throw new ErrorMessageException(ErrorMessage.SYSTEM_ERROR);
        }
    }
    public int update(Product product)
    {
        int i=productDao.update(product);
        if(i>0)
        {
            return i;
        }
        else
        {
            throw new ErrorMessageException(ErrorMessage.SYSTEM_ERROR);
        }
    }
    public int delete(int id)
    {
        int i=productDao.delete(id);
        if(i>0)
        {
            return i;
        }
        else
        {
            throw new ErrorMessageException(ErrorMessage.SYSTEM_ERROR);
        }
    }
    public List<Product> search(String id, String keyword, String rows, String page, String sidx, String sord)
    {
        List<Product> list=productDao.search( id,  keyword,  rows,  page,  sidx,  sord);
        return list;
    }


}