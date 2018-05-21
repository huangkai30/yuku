package com.lastcompany.haiwaicang.dao.impl;

import com.lastcompany.haiwaicang.dao.IUserLoginDao;
import com.lastcompany.haiwaicang.entity.UserLogin;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Repository
public class UserLoginDao implements IUserLoginDao {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public UserLogin getById(int id) {
		return entityManager.find(UserLogin.class, id);
	}

	@Override
	public int add(UserLogin userLogin) {
		entityManager.persist(userLogin);
		return 1;
	}
	@Override
	public int update(UserLogin userLogin) {
		UserLogin re = getById(userLogin.getId());
		if(re==null)
		{
			return 0;
		}
		else
		{
			re=userLogin;
			entityManager.flush();
			return 1;
		}
	}


	@Override
	public int delete(int id) {

		UserLogin re = getById(id);
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
	public List<UserLogin> search(String id, String keyword,String rows, String page,String sidx,String sord) {
		String hql ="";
		List<UserLogin> list=null;
		if(id!=null&&id!="")
		{
			hql = "FROM UserLogin as ha WHERE ha.id = :id";
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
			hql="FROM UserLogin as ha WHERE ha.userName = :keyword or ha.description = :keyword order by :sidx :sord limit :page, :rows";
			list = entityManager.createQuery(hql).setParameter("keyword", keyword).setParameter("sidx", sidx).setParameter("sord", sord).setParameter("page", page).setParameter("rows", rows).getResultList();
		}



		return list;

	}

}
