package com.example.Service.API;

import com.example.model.Article;

import java.util.List;
import java.util.Optional;

public interface ArticleService {
    Article addArticle(Article article);
    void deleteArticleById(long id);
    Optional<Article> getArticleById(long id);
    Article editArticle(Article article);
    List<Article> getAllArticles();
}
