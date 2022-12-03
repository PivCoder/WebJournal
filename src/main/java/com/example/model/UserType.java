package com.example.model;

import javax.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity(name = "user_type")
@Table(name = "user_types")
public class UserType extends AbstractObject{

    @Column
    private String roleName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "userType", cascade = CascadeType.ALL)
    private List<User> users;

    public UserType(){

    }

    public UserType(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
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
        if (!(o instanceof UserType)) return false;
        UserType userType = (UserType) o;
        return Objects.equals(getId(), userType.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "UserType{" +
                "roleName='" + roleName + '\'' +
                '}';
    }
}
