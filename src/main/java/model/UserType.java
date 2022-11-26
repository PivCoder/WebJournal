package model;

import lombok.*;

import javax.persistence.*;

import java.util.List;
import java.util.Objects;

@Data
@NoArgsConstructor
@Entity(name = "User_type")
@Table(name = "user_types")
public class UserType extends AbstractObject{

    @Column
    private String roleName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "userType")
    private List<User> users;

    public UserType(String roleName) {
        this.roleName = roleName;
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
