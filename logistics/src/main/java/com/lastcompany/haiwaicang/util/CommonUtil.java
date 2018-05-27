package com.lastcompany.haiwaicang.util;

import com.lastcompany.haiwaicang.entity.SearchObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class CommonUtil {
    /**
     * 通过网络访问json并读取文件
     * @param url:
     * @return:json文件的内容
     */
    public static String loadJson (String url) {
        StringBuilder json = new StringBuilder();
        try {
            URL urlObject = new URL(url);
            URLConnection uc = urlObject.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream(),"UTF-8"));
            String inputLine = null;
            while ( (inputLine = in.readLine()) != null) {
                json.append(inputLine);
            }
            in.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json.toString();
    }

    //totalnum当前的总页数，page实际请求的第几页，rows每页的数量
    public static SearchObject fit_search(int totalnum, int page,int rows)
    {
        SearchObject obj=new SearchObject();
        obj.setTotalnum(totalnum);
        obj.setCurpage(page);
        obj.setRequest_rows(rows);
        int totalpage=0;
        if(totalnum%rows==0)
        {
            totalpage=(int)(totalnum/rows);
        }
        else
        {
            totalpage=(int)(totalnum/rows)+1;
        }
        obj.setTotalpage(totalpage);

       return obj;
    }

}
