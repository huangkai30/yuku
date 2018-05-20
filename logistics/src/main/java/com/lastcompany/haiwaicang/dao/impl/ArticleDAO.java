package com.lastcompany.haiwaicang.dao.impl;

import com.lastcompany.haiwaicang.entity.*;
import org.springframework.stereotype.Repository;

import com.lastcompany.haiwaicang.dao.IArticleDAO;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Repository
public class ArticleDAO implements IArticleDAO {
	@PersistenceContext	
	private EntityManager entityManager;	
	@Override
	public Article getArticleById(int articleId) {
		return entityManager.find(Article.class, articleId);
	}
	@Override
	public Article getArticleByTitle(String title)
	{

		String hql1 = "FROM Article as atcl WHERE atcl.title = ?";
		List<Article> list1 = entityManager.createQuery(hql1).setParameter(1, title).getResultList();

		String hql = "FROM Article as atcl WHERE atcl.title = ?";
		List<Article> list = entityManager.createQuery(hql).setParameter(1, title).getResultList();
		if(list!=null&&list.size()>0)
		{
			return list.get(0);
		}
		else
		{
			return null;
		}

	}



	@SuppressWarnings("unchecked")
	@Override
	public List<Article> getAllArticles() {
		String hql = "FROM Article as atcl ORDER BY atcl.articleId";
		return (List<Article>) entityManager.createQuery(hql).getResultList();
	}	
	@Override
	public void addArticle(Article article) {
		entityManager.persist(article);
	}
	@Override
	public void updateArticle(Article article) {
		Article artcl = getArticleById(article.getArticleId());
		artcl.setTitle(article.getTitle());
		artcl.setCategory(article.getCategory());
		entityManager.flush();
	}
	@Override
	public void deleteArticle(int articleId) {
		entityManager.remove(getArticleById(articleId));
	}
	@Override
	public boolean articleExists(String title, String category) {
		String hql = "FROM Article as atcl WHERE atcl.title = ?1 and atcl.category = ?2";
		int count = entityManager.createQuery(hql).setParameter(1, title)
		              .setParameter(2, category).getResultList().size();
		return count > 0 ? true : false;
	}



	@Override
	public List<Article> search(String title) {
		String hql = "FROM Article as atcl WHERE atcl.title = ?";
		List<Article> list = entityManager.createQuery(hql).setParameter(1, title).getResultList();
		return list;
	}
}
