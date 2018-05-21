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


	}


	@Override
	public User getById(int id) {
		return entityManager.find(User.class, id);
	}

	@Override
	public int add(User user) {
		entityManager.persist(user);
		return 1;
	}
	@Override
	public int update(User user) {
		User re = getById(user.getId());
		if(re==null)
		{
			return 0;
		}
		else
		{
			re=user;
			entityManager.flush();
			return 1;
		}
	}


	@Override
	public int delete(int id) {

		User re = getById(id);
		if(re==null)
		{
			return 0;
		}
		else
		{
			entityManager.remove(re);
			return 1;
		}

	}



	@Override
	public List<User> search(String id, String keyword,String rows, String page,String sidx,String sord) {
		String hql ="";
		List<User> list=null;
		if(id!=null&&id!="")
		{
			hql = "FROM User as ha WHERE ha.id = :id";
			list = entityManager.createQuery(hql).setParameter("id", id).getResultList();
		}
		else
		{
			hql = "";
			if(keyword!=null&&keyword!="")
			{
				keyword="%"+keyword+"%";

			}
			else
			{
				keyword="%";
			}
			hql="FROM User as ha WHERE ha.name = :keyword or ha.brand = :keyword or ha.description = :keyword order by :sidx :sord limit :page, :rows";
			list = entityManager.createQuery(hql).setParameter("keyword", keyword).setParameter("sidx", sidx).setParameter("sord", sord).setParameter("page", page).setParameter("rows", rows).getResultList();
		}



		return list;

	}




}
