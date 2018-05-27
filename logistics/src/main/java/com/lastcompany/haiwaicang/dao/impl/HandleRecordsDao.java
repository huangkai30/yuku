package com.lastcompany.haiwaicang.dao.impl;

import com.lastcompany.haiwaicang.dao.IHandleRecordsDao;
import com.lastcompany.haiwaicang.entity.HandleRecords;
//import com.lastcompany.haiwaicang.entity.User;
import com.lastcompany.haiwaicang.entity.SearchObject;
import com.lastcompany.haiwaicang.util.CommonUtil;
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
	public SearchObject search(String id, String keyword, int rows, int page, String sidx, String sord) {
		String hql ="";
		List<HandleRecords> list=new ArrayList<HandleRecords>();
		SearchObject obj= null;
		if(id!=null&&id!="")
		{
			hql = "FROM HandleRecords as ha WHERE ha.id = :id";
			int totalnum=entityManager.createQuery(hql).setParameter("id", id).getResultList().size();

			obj=CommonUtil.fit_search(totalnum,page,rows);

			if(obj.getTotalpage()<page)
			{
				list=null;
				obj.setCurrows(0);
				obj.setData(list);
			}
			else
			{
				list = entityManager.createQuery(hql).setParameter("id", id).getResultList();
				if(list!=null)
				{
					obj.setCurrows(list.size());
					obj.setData(list);
				}
			}





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

			hql="FROM HandleRecords as ha WHERE ha.userName like :keyword or ha.description like :keyword";
			int totalnum=entityManager.createQuery(hql).setParameter("keyword",keyword).getResultList().size();

			obj=CommonUtil.fit_search(totalnum,page,rows);


			if(obj.getTotalpage()<page)
			{
				list=null;
				obj.setCurrows(0);
				obj.setData(list);
			}
			else
			{
				int first=(page-1)*rows;
				if(sidx==null || sord==null)
				{
					list = entityManager.createQuery(hql).setParameter("keyword",keyword).setFirstResult(first).setMaxResults(rows).getResultList();
				//	list = entityManager.createQuery(hql).setFirstResult(first).getResultList();

				}
				else
				{

					hql="FROM HandleRecords as ha WHERE ha.userName like :keyword or ha.description like :keyword order by ha."+sidx+" "+sord;
					list = entityManager.createQuery(hql).setParameter("keyword", keyword).setFirstResult(first).setMaxResults(rows).getResultList();

				}
				if(list==null)
				{
					obj.setCurrows(0);
				}
				else
				{
					obj.setCurrows(list.size());
				}

				obj.setData(list);
			}


		}



		return obj;

	}

}
