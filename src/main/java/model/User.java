package model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@Entity
@Table(name = "Пользователи")
public class User extends AbstractObject{

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

    @ManyToMany
    List<Article> articleList;

    public User( String surname,String name, String patronymic,Double rating, String pictureRef) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.rating = rating;
        this.pictureRef = pictureRef;
    }
}

