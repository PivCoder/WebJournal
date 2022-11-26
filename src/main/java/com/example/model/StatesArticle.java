package com.example.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity(name = "state")
@Table(name = "states")
public class StatesArticle extends AbstractObject{

    @Column
    private String state;

    @OneToMany(mappedBy = "statesArticle", fetch = FetchType.LAZY)
    private List<Article> articles;

    public StatesArticle(){

    }

    public StatesArticle(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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
        if (!(o instanceof StatesArticle)) return false;
        StatesArticle statesArticle = (StatesArticle) o;
        return Objects.equals(getId(), statesArticle.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "StatesArticle{" +
                "state='" + state + '\'' +
                '}';
    }
}

