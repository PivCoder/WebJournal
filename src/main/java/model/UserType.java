package model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.util.List;
import java.util.Objects;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Тип_Пользователей")
public class UserType extends AbstractObject{

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "userType")//, cascade = CascadeType.ALL, orphanRemoval = true
    private List<User> users;

    @Column(name = "Наименование_Роли")
    private String roleName;

    public UserType(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserType)) return false;

        UserType userType = (UserType) o;

        if (!Objects.equals(users, userType.users)) return false;
        return Objects.equals(roleName, userType.roleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), users, roleName);
    }

    @Override
    public String toString() {
        return "UserType{" +
                "id=" + getId() +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
