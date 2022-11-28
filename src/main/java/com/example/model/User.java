package com.example.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity(name = "user")
@Table(name = "users")
public class User extends AbstractObject{

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String patronymic;

    @Column
    private Double rating;

    @Column
    private String pictureRef;

    @OneToOne(mappedBy = "user")
    private Authorization authorization;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_type_id")
    private UserType userType;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "users")
    List<Article> articleList;

    public User(){

    }

    public User(String name,
                String surname,
                String patronymic, Double rating, String pictureRef, UserType userType) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.rating = rating;
        this.pictureRef = pictureRef;
        this.userType = userType;
    }

    public User(String name,
                String surname,
                String patronymic,
                Double rating,
                String pictureRef, Authorization authorization, UserType userType, List<Article> articleList) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.rating = rating;
        this.pictureRef = pictureRef;
        this.authorization = authorization;
        this.userType = userType;
        this.articleList = articleList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getPictureRef() {
        return pictureRef;
    }

    public void setPictureRef(String pictureRef) {
        this.pictureRef = pictureRef;
    }

    public Authorization getAuthorization() {
        return authorization;
    }

    public void setAuthorization(Authorization authorization) {
        this.authorization = authorization;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public List<Article> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<Article> articleList) {
        this.articleList = articleList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(getId(), user.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", rating=" + rating +
                ", pictureRef='" + pictureRef + '\'' +
                '}';
    }
}


