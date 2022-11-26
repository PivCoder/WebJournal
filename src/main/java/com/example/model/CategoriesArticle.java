package com.example.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity(name = "category")
@Table(name = "categories")
public class CategoriesArticle extends AbstractObject{

    @Column
    private String category;

    @OneToMany(mappedBy = "categoriesArticle", fetch = FetchType.LAZY)
    private List<Article> articles;

    public CategoriesArticle(){

    }

    public CategoriesArticle(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CategoriesArticle)) return false;
        CategoriesArticle categoriesArticle = (CategoriesArticle) o;
        return Objects.equals(getId(), categoriesArticle.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "CategoriesArticle{" +
                "category='" + category + '\'' +
                '}';
    }
}
