package com.lastcompany.haiwaicang.dao.impl;

import com.lastcompany.haiwaicang.dao.IProductDao;
import com.lastcompany.haiwaicang.dao.IProductDao;
import com.lastcompany.haiwaicang.entity.HandleRecords;
import com.lastcompany.haiwaicang.entity.Product;
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
public class ProductDao implements IProductDao {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Product getById(int id) {
		return entityManager.find(Product.class, id);
	}

	@Override
	public Product updateInventory(int id,int inventory)
	{
		Product re = getById(id);
		if(re==null)
		{
			return null;
		}
		else
		{

			re.setInventory(inventory);

			entityManager.flush();
			return re;
		}
	}


	@Override
	public Product getBySku(String sku) {
		String hql="FROM Product as ha WHERE ha.sku = :sku";
		List<Product> list=entityManager.createQuery(hql).setParameter("sku",sku).getResultList();
		if(list==null||list.size()==0)
		{
			return null;
		}

		return list.get(0);
	}
	@Override
	public int add(Product product) {
		entityManager.persist(product);
		return 1;
	}
	@Override
	public int update(Product product) {
		Product re = getById(product.getId());
		if(re==null)
		{
			return 0;
		}
		else
		{
			re.setDateModified(product.getDateModified());
			re.setBrand(product.getBrand());
			re.setDescription(product.getDescription());
			re.setInventory(product.getInventory());
			re.setName(product.getName());
			re.setLastpersion(product.getLastpersion());

			entityManager.flush();
			return 1;
		}
	}


	@Override
	public int delete(int id) {

		Product re = getById(id);
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
		List<Product> list=new ArrayList<Product>();
		SearchObject obj= null;
		if(id!=null&&id!="")
		{
			hql = "FROM Product as ha WHERE ha.id = :id";
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

			hql="FROM Product as ha WHERE ha.sku like :keyword or ha.name like :keyword or ha.brand like :keyword or ha.description like :keyword";
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

					hql="FROM Product as ha WHERE ha.sku like :keyword or ha.name like :keyword or ha.brand like :keyword or ha.description like :keyword order by ha."+sidx+" "+sord;
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



	@Override
	public boolean existsku(String sku){
		String hql="FROM Product as ha WHERE ha.sku = :sku";
		int totalnum=entityManager.createQuery(hql).setParameter("sku",sku).getResultList().size();
		if(totalnum>0)
		{
			return true;
		}
		return false;
	}

}
