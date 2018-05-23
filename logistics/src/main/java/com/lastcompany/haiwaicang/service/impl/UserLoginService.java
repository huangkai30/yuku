package com.lastcompany.haiwaicang.service.impl;

import com.lastcompany.haiwaicang.constant.ErrorMessage;
import com.lastcompany.haiwaicang.constant.ErrorMessageException;
import com.lastcompany.haiwaicang.dao.IUserLoginDao;
import com.lastcompany.haiwaicang.entity.User;
import com.lastcompany.haiwaicang.entity.UserLogin;
import com.lastcompany.haiwaicang.service.IUserLoginService;
import com.lastcompany.haiwaicang.util.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
//@Transactional(readOnly = true)
public class UserLoginService implements IUserLoginService {

    @Autowired
    private IUserLoginDao userLoginDao;

   public UserLogin getById(int id)
    {
      return  userLoginDao.getById(id);
    }



    public int add(UserLogin userLogin)
    {
        userLogin.setDateCreated(new Date());
        userLogin.setDateModified(new Date());
        int i=userLoginDao.add(userLogin);
        if(i>0)
        {
            return i;
        }
        else
        {
            throw new ErrorMessageException(ErrorMessage.SYSTEM_ERROR);
        }
    }
    public int update(UserLogin userLogin)
    {
        int i=userLoginDao.update(userLogin);
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
        int i=userLoginDao.delete(id);
        if(i>0)
        {
            return i;
        }
        else
        {
            throw new ErrorMessageException(ErrorMessage.SYSTEM_ERROR);
        }
    }
    public List<UserLogin> search(String id, String keyword, String rows, String page, String sidx, String sord)
    {
        List<UserLogin> list=userLoginDao.search( id,  keyword,  rows,  page,  sidx,  sord);
        return list;
    }


}