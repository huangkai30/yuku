package com.lastcompany.haiwaicang.service.impl;

import com.lastcompany.haiwaicang.constant.ErrorMessage;
import com.lastcompany.haiwaicang.constant.ErrorMessageException;
import com.lastcompany.haiwaicang.dao.IHandleRecordsDao;
import com.lastcompany.haiwaicang.entity.HandleRecords;
import com.lastcompany.haiwaicang.entity.SearchObject;
import com.lastcompany.haiwaicang.service.IHandleRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

//import com.lastcompany.haiwaicang.service.IHandleRecordsService;


@Service
//@Transactional(readOnly = true)
public class HandleRecordsService implements IHandleRecordsService {

    @Autowired
    private IHandleRecordsDao handleRecordsDao;

   public HandleRecords getById(int id)
    {
      return  handleRecordsDao.getById(id);
    }



    public int add(HandleRecords handleRecords)
    {
        handleRecords.setDateCreated(new Date());
        handleRecords.setDateModified(new Date());
        int i=handleRecordsDao.add(handleRecords);
        if(i>0)
        {
            return i;
        }
        else
        {
            throw new ErrorMessageException(ErrorMessage.SYSTEM_ERROR);
        }
    }
    public int update(HandleRecords handleRecords)
    {
        int i=handleRecordsDao.update(handleRecords);
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
        int i=handleRecordsDao.delete(id);
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
        SearchObject list=handleRecordsDao.search( id,  keyword,  rows,  page,  sidx,  sord);
        return list;
    }


}