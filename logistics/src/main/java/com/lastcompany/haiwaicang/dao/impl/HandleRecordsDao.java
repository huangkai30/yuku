package com.lastcompany.haiwaicang.dao.impl;

import com.lastcompany.haiwaicang.dao.IHandleRecordsDao;
import com.lastcompany.haiwaicang.entity.HandleRecords;
//import com.lastcompany.haiwaicang.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Repository
public class HandleRecordsDao implements IHandleRecordsDao {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public HandleRecords getById(int id) {
		return entityManager.find(HandleRecords.class, id);
	}

	@Override
	public int add(HandleRecords records) {
		entityManager.persist(records);
		return 1;
	}
	@Override
	public int update(HandleRecords records) {
		HandleRecords re = getById(records.getId());
		if(re==null)
		{
			return 0;
		}
		else
		{
			re=records;
			entityManager.flush();
			return 1;
		}
	}


	@Override
	public int delete(int id) {

		HandleRecords re = getById(id);
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
	public List<HandleRecords> search(String id, String keyword,String rows, String page,String sidx,String sord) {
		String hql ="";
		List<HandleRecords> list=new ArrayList<HandleRecords>();
		if(id!=null&&id!="")
		{
			hql = "FROM HandleRecords as ha WHERE ha.id = :id";
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
			hql="FROM HandleRecords as ha WHERE ha.userName = :keyword or ha.description = :keyword order by :sidx :sord limit :page, :rows";
			list = entityManager.createQuery(hql).setParameter("keyword", keyword).setParameter("sidx", sidx).setParameter("sord", sord).setParameter("page", page).setParameter("rows", rows).getResultList();
		}



		return list;

	}

}
