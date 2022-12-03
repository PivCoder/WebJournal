package com.example.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity(name = "authorization")
@Table(name = "authorizations")
public class Authorization extends AbstractObject{

    @Column
    private String login;

    @Column
    private String password;

    @OneToMany(mappedBy = "authorization", fetch = FetchType.LAZY)
    private List<User> users;

    public Authorization(){

    }

    public Authorization(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public Authorization(String login, String password, List<User> users) {
        this.login = login;
        this.password = password;
        this.users = users;
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

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
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
