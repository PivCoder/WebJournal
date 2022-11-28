package com.example.model;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "authorization")
@Table(name = "authorizations")
public class Authorization extends AbstractObject{

    @Column
    private String login;

    @Column
    private String password;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public Authorization(){

    }

    public Authorization(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public Authorization(String login, String password, User user) {
        this.login = login;
        this.password = password;
        this.user = user;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Authorization)) return false;
        Authorization authorization = (Authorization) o;
        return Objects.equals(getId(), authorization.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Authorization{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
