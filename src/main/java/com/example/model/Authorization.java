package com.example.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity(name = "authorization")
@Table(name = "authorizations")
public class Authorization extends AbstractObject implements UserDetails {

    @Column
    private String username;

    @Column
    private String password;

    @OneToMany(mappedBy = "authorization", fetch = FetchType.LAZY)
    private List<User> users;

    public Authorization(){

    }

    public Authorization(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Authorization(String username, String password, List<User> users) {
        this.username = username;
        this.password = password;
        this.users = users;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
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
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
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
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
