package com.lastcompany.haiwaicang.service;

import com.lastcompany.haiwaicang.entity.Article;

import java.util.List;

public interface IArticleService {
     List<Article> getAllArticles();
     Article getArticleById(int articleId);
     boolean addArticle(Article article);
     void updateArticle(Article article);
     void deleteArticle(int articleId);
     public Article getArticleByTitle(String title);
     List<Article> search(String title);
}
