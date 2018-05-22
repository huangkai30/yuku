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
        return  userDao.getById(id);
    }



    public int add(User user)
    {
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


}