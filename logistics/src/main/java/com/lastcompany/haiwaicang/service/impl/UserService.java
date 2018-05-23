package com.lastcompany.haiwaicang.service.impl;

import com.lastcompany.haiwaicang.dao.IUserDao;
import com.lastcompany.haiwaicang.entity.User;

import com.lastcompany.haiwaicang.entity.UserLogin;
import com.lastcompany.haiwaicang.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lastcompany.haiwaicang.constant.*;
import com.lastcompany.haiwaicang.util.*;

import java.util.List;
import java.util.Date;


@Service
//@Transactional(readOnly = true)
public class UserService implements IUserService {

    @Autowired
    private IUserDao userDao;

    public User login(String userName, String password) {
       // String passwordstr=MD5.md5(password);
        User user = userDao.getUserbyUserName(userName);
        if (user == null) {
            throw new ErrorMessageException(ErrorMessage.Member.USERNAME_ERROR);
        }


        if (!MD5.md5(password).equals(user.getPassWord())) {
            throw new ErrorMessageException(ErrorMessage.Member.PASSWORD_ERROR);
        }
//        if (user.getIsEnable()==0) {
//            throw new ErrorMessageException(ErrorMessage.Member.FORBIDDEN);
//        }
        return user;
    }



    public User getById(int id)
    {
        User user=userDao.getById(id);
        if(user!=null)
        {
            user.setPassWord("");
        }
        return  user;
    }



    public int add(User user)
    {
        user.setDateCreated(new Date());
        user.setDateModified(new Date());
        int i=userDao.add(user);
        if(i>0)
        {
            return i;
        }
        else
        {
            throw new ErrorMessageException(ErrorMessage.SYSTEM_ERROR);
        }
    }
    public int update(User user)
    {
        int i=userDao.update(user);
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
        int i=userDao.delete(id);
        if(i>0)
        {
            return i;
        }
        else
        {
            throw new ErrorMessageException(ErrorMessage.SYSTEM_ERROR);
        }
    }
    public List<User> search(String id, String keyword, String rows, String page, String sidx, String sord)
    {
        List<User> list=userDao.search( id,  keyword,  rows,  page,  sidx,  sord);
        return list;
    }


    public User resetpw(int id,String old_password, String password)
    {
        User user=userDao.getById(id);
        if(user==null)
        {
            throw new ErrorMessageException(ErrorMessage.SYSTEM_ERROR);
        }
        if (!MD5.md5(old_password).equals(user.getPassWord())) {
            throw new ErrorMessageException(ErrorMessage.Member.PASSWORD_ERROR);
        }
        user.setPassWord(MD5.md5(password));
        user.setDateModified(new Date());
        int i=userDao.update(user);
        if(i>0)
        {}
        else
        {
            return null;
        }

        return user;
    }
}