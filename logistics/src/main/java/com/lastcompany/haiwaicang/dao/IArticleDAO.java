package com.lastcompany.haiwaicang.dao;

import com.lastcompany.haiwaicang.entity.*;

import java.util.List;

public interface IArticleDAO {
    List<Article> getAllArticles();
    Article getArticleById(int articleId);
    Article getArticleByTitle(String title);


    void addArticle(Article article);
    void updateArticle(Article article);
    void deleteArticle(int articleId);
    boolean articleExists(String title, String category);
    public List<Article> search(String title);


}
 