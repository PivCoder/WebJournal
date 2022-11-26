package com.example.Service.Implements;

import com.example.Repositoryes.CategoriesArticleRepository;
import com.example.Service.CategoriesArticleService;
import com.example.model.CategoriesArticle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriesArticleImplement implements CategoriesArticleService {

    @Autowired
    CategoriesArticleRepository categoriesArticleRepository;

    @Override
    public CategoriesArticle addCategoriesArticle(CategoriesArticle categoriesArticle) {
        CategoriesArticle savedCategoriesArticle = categoriesArticleRepository.saveAndFlush(categoriesArticle);
        return savedCategoriesArticle;
    }

    @Override
    public void deleteCategoriesArticle(long id) {
        categoriesArticleRepository.deleteById(id);
    }

    @Override
    public Optional<CategoriesArticle> getCategoriesArticleById(long id) {
        return categoriesArticleRepository.findById(id);
    }

    @Override
    public CategoriesArticle editCategoriesArticle(CategoriesArticle categoriesArticle) {
        return categoriesArticleRepository.saveAndFlush(categoriesArticle);
    }

    @Override
    public List<CategoriesArticle> getAllCategoriesArticle() {
        return categoriesArticleRepository.findAll();
    }
}
