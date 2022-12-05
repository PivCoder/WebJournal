package com.example.model;

import com.example.model.Enums.Categories;
import com.example.model.Enums.States;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity(name = "article")
@Table(name = "articles")
public class Article extends AbstractObject {
    @Column
    private String name;

    @Column
    private int countPages;

    @Column
    private int countVisits;

    @Column
    private String pictureRef;

    @Column
    private States state;

    @Column
    private Categories category;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "articles_users",
            joinColumns = { @JoinColumn(name = "articles_id") },
            inverseJoinColumns = { @JoinColumn(name = "users_id") })
    List<User> users;

    public Article(){

    }

    public Article(String name, int countPages, int countVisits, String pictureRef) {
        this.name = name;
        this.countPages = countPages;
        this.countVisits = countVisits;
        this.pictureRef = pictureRef;
    }

    public Article(String name, int countPages, int countVisits, String pictureRef, States state, Categories category) {
        this.name = name;
        this.countPages = countPages;
        this.countVisits = countVisits;
        this.pictureRef = pictureRef;
        this.state = state;
        this.category = category;
    }

    public Article(String name, int countPages, int countVisits, String pictureRef, States state, Categories category, List<User> users) {
        this.name = name;
        this.countPages = countPages;
        this.countVisits = countVisits;
        this.pictureRef = pictureRef;
        this.state = state;
        this.category = category;
        this.users = users;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCountPages() {
        return countPages;
    }

    public void setCountPages(int countPages) {
        this.countPages = countPages;
    }

    public int getCountVisits() {
        return countVisits;
    }

    public void setCountVisits(int countVisits) {
        this.countVisits = countVisits;
    }

    public String getPictureRef() {
        return pictureRef;
    }

    public void setPictureRef(String pictureRef) {
        this.pictureRef = pictureRef;
    }

    public States getState() {
        return state;
    }

    public void setState(States state) {
        this.state = state;
    }

    public Categories getCategory() {
        return category;
    }

    public void setCategory(Categories category) {
        this.category = category;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Article)) return false;
        Article article = (Article) o;
        return Objects.equals(getId(), article.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Article{" +
                "name='" + name + '\'' +
                ", countPages=" + countPages +
                ", countVisits=" + countVisits +
                ", pictureRef='" + pictureRef + '\'' +
                ", state='" + state + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
