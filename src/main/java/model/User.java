package model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Пользователи")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", updatable = false, nullable = false)
    private int id;

    @Column(name = "Имя")
    private String name;

    @Column(name = "Фамилия")
    private String surname;

    @Column(name = "Отчество")
    private String patronymic;

    @Column(name = "Рейтинг")
    private Double rating;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Тип_Пользователя")
    private UserType userType;

    @Column(name = "Ссылка_картинка")
    private String pictureRef;

    public User( String surname,String name, String patronymic,Double rating, String pictureRef) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.rating = rating;
        this.pictureRef = pictureRef;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (!Objects.equals(name, user.name)) return false;
        if (!Objects.equals(surname, user.surname)) return false;
        if (!Objects.equals(patronymic, user.patronymic)) return false;
        if (!Objects.equals(userType, user.userType)) return false;
        return Objects.equals(pictureRef, user.pictureRef);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), name, surname, patronymic, userType, pictureRef);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + getId()+
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", pictureRef='" + pictureRef + '\'' +
                '}';
    }
}

