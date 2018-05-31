package com.lastcompany.haiwaicang.service.impl;

import com.lastcompany.haiwaicang.constant.ErrorMessage;
import com.lastcompany.haiwaicang.constant.ErrorMessageException;
import com.lastcompany.haiwaicang.dao.IProductDao;
import com.lastcompany.haiwaicang.dao.IUserLoginDao;
import com.lastcompany.haiwaicang.entity.Product;
import com.lastcompany.haiwaicang.entity.SearchObject;
import com.lastcompany.haiwaicang.entity.UserLogin;
import com.lastcompany.haiwaicang.service.IProductService;
//import com.lastcompany.haiwaicang.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    public Product getBySku(String sku)
    {
        return  productDao.getBySku(sku);
    }

    public Product addInventory(String sku,int inventory)
    {
        Product re=productDao.getBySku(sku);
        if(re==null)
        {
            throw new ErrorMessageException("No this product by this Sku: "+sku);
        }
        else
        {
            int newin=inventory+re.getInventory();
            Product re1=productDao.updateInventory(re.getId(),newin);
            return re1;

        }

    }
    public Product removeInventory(String sku,int inventory)
    {
        Product re=productDao.getBySku(sku);
        if(re==null)
        {
            throw new ErrorMessageException("No this product by this Sku: "+sku);
        }
        else
        {
            int newin=re.getInventory()-inventory;
            if(newin<0)
            {
                throw new ErrorMessageException("There is not enough inventory("+re.getInventory()+") Sku: "+sku);
            }
            Product re1=productDao.updateInventory(re.getId(),newin);
            return re1;

        }
    }




    public int add(Product product)
    {

        if(product.getSku()==null)
        {
            throw new ErrorMessageException("Sku can not be empty.");
        }
        else if(productDao.existsku(product.getSku()))
        {
            throw new ErrorMessageException("Sku already exist.");
        }
        product.setDateCreated(new Date());
        product.setDateModified(new Date());
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
        product.setDateModified(new Date());
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
    public SearchObject search(String id, String keyword, int rows, int page, String sidx, String sord)
    {
        SearchObject list=productDao.search( id,  keyword,  rows,  page,  sidx,  sord);
        return list;
    }


}