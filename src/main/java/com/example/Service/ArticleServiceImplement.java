package com.example.Service;

import com.example.Repositoryes.ArticleRepository;
import com.example.Service.API.ArticleService;
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
        Article savedArticle = articleRepository.save(article);
        return savedArticle;
    }

    @Override
    public void deleteArticleById(long id) {
        articleRepository.deleteById(id);
    }

    //TODO добавить условие вывода не Null во всех сущностях
    @Override
    public Optional<Article> getArticleById(long id) {
        return articleRepository.findById(id);
    }

    @Override
    public Article editArticle(Article article) {
        return articleRepository.save(article);
    }

    @Override
    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }
}
