package com.lastcompany.haiwaicang.dao.impl;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.lastcompany.haiwaicang.dao.IUserDao;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lastcompany.haiwaicang.entity.*;
@Transactional
@Repository
public class UserDao implements IUserDao {
	@PersistenceContext
	private EntityManager entityManager;

//	@Override
//	public boolean articleExists(String title, String category) {
//		String hql = "FROM Article as atcl WHERE atcl.title = ? and atcl.category = ?";
//		int count = entityManager.createQuery(hql).setParameter(1, title)
//		              .setParameter(2, category).getResultList().size();
//		return count > 0 ? true : false;
//	}
	@Override
	public User getUserbyUserName(String userName)
	{
		//String hql = "FROM user WHERE user.userName = ?";

		String hql = "FROM User as user1 WHERE user1.userName = :username";


		List<User> list =entityManager.createQuery(hql).setParameter("username", userName).getResultList();

		if(list!=null&&list.size()>0)
		{
			return list.get(0);
		}
		else
		{
			return null;
		}

//		User user =new User();
//		return (User)user;
	}
}
