package com.lastcompany.haiwaicang.dao;


        import java.util.List;
        import com.lastcompany.haiwaicang.entity.*;
public interface IUserDao {
    User getById(int id);



    int add(User user);
    int update(User user);
    int delete(int id);

    //rows 表示一页多少行，page表示第几页，sidx进行排列的列名，sord排序的升降序asc、desc
    public List<User> search(String id, String keyword, String rows, String page, String sidx, String sord);
//    boolean articleExists(String title, String category);
    User getUserbyUserName(String userName);

}
