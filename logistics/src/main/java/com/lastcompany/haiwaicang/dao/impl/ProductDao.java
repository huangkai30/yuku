package com.lastcompany.haiwaicang.dao.impl;

import com.lastcompany.haiwaicang.dao.IProductDao;
import com.lastcompany.haiwaicang.dao.IProductDao;
import com.lastcompany.haiwaicang.entity.Product;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
			re=product;
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
	public List<Product> search(String id, String keyword,String rows, String page,String sidx,String sord) {
		String hql ="";
		List<Product> list=null;
		if(id!=null&&id!="")
		{
			hql = "FROM Product as ha WHERE ha.id = :id";
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
			hql="FROM Product as ha WHERE ha.name = :keyword or ha.brand = :keyword or ha.description = :keyword order by :sidx :sord limit :page, :rows";
			list = entityManager.createQuery(hql).setParameter("keyword", keyword).setParameter("sidx", sidx).setParameter("sord", sord).setParameter("page", page).setParameter("rows", rows).getResultList();
		}



		return list;

	}

}
