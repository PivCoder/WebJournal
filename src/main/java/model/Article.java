package model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@Entity
@Table(name = "Статьи")
public class Article extends AbstractObject {
    @Column(name = "Название")
    private String name;

    @Column(name = "Количество_Страниц")
    private int countPages;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Состояние")
    private StatesArticle statesArticle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Категория")
    private CategoriesArticle categoriesArticle;

    @Column(name = "Количество_Посещений")
    private int countVisits;

    @Column(name = "Ссылка_Картинка")
    private String pictureRef;

    @ManyToMany
    List<User> users;

    public Article(String name,
                   int countPages,
                   StatesArticle statesArticle,
                   CategoriesArticle categoriesArticle,
                   int countVisits,
                   String pictureRef,
                   List<User> users) {
        this.name = name;
        this.countPages = countPages;
        this.statesArticle = statesArticle;
        this.categoriesArticle = categoriesArticle;
        this.countVisits = countVisits;
        this.pictureRef = pictureRef;
        this.users = users;
    }
}
