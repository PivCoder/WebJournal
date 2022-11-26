package com.example.Service.Implements;

import com.example.Repositoryes.ArticleRepository;
import com.example.Service.ArticleService;
import com.example.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleServiceImplement implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public Article addArticle(Article article) {
        Article savedArticle = articleRepository.saveAndFlush(article);
        return savedArticle;
    }

    @Override
    public void deleteArticleById(long id) {
        articleRepository.deleteById(id);
    }

    @Override
    public Optional<Article> getArticleById(long id) {
        return articleRepository.findById(id);
    }

    @Override
    public Article editArticle(Article article) {
        return articleRepository.saveAndFlush(article);
    }

    @Override
    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }
}
