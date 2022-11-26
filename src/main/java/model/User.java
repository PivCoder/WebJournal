package model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Data
@NoArgsConstructor
@Entity(name = "User")
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

    public User(String surname,String name, String patronymic, Double rating, String pictureRef) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.rating = rating;
        this.pictureRef = pictureRef;
    }

    public User(String surname,String name, Double rating, String pictureRef) {
        this.name = name;
        this.surname = surname;
        this.rating = rating;
        this.pictureRef = pictureRef;
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


