package com.example.Service;

import com.example.model.CategoriesArticle;

import java.util.List;
import java.util.Optional;

public interface CategoriesArticleService {
    CategoriesArticle addCategoriesArticle(CategoriesArticle categoriesArticle);
    void deleteCategoriesArticle(long id);
    Optional<CategoriesArticle> getCategoriesArticleById(long id);
    CategoriesArticle editCategoriesArticle(CategoriesArticle categoriesArticle);
    List<CategoriesArticle> getAllCategoriesArticle();
}
