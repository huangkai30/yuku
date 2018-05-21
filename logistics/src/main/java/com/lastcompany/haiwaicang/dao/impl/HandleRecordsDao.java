package com.lastcompany.haiwaicang.dao.impl;

import com.lastcompany.haiwaicang.dao.IHandleRecordsDao;
import com.lastcompany.haiwaicang.entity.HandleRecords;
import com.lastcompany.haiwaicang.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
//		String hql ="";
//		if(id!=null&&id!="")
//		{
//			hql = "FROM HandleRecords as ha WHERE ha.id = :id";
//		}
//		else
//		{
//			hql = "FROM HandleRecords ";
//			if(keyword!=null&&keyword!="")
//			{
//				keyword="%"+keyword+"%";
//				hql+="as ha WHERE ha. = :keyword or ";
//			}
//		}
//
//
//		List<HandleRecords> list = entityManager.createQuery(hql).setParameter(1, title).getResultList();
//		return list;
		return null;
	}

}
