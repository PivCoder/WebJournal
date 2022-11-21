package model;

import lombok.*;

import javax.persistence.*;

import java.util.List;
import java.util.Objects;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@Entity
@Table(name = "Тип_Пользователей")
public class UserType extends AbstractObject{

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "userType")//, cascade = CascadeType.ALL, orphanRemoval = true
    private List<User> users;

    @Column(name = "Наименование_Роли")
    private String roleName;

    public UserType(List<User> users, String roleName) {
        this.users = users;
        this.roleName = roleName;
    }
}
