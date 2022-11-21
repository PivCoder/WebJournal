package model;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@Entity
@Table(name = "Состояния")
public class StatesArticle extends AbstractObject{

    @Column(name = "Состояние")
    private String Сategory;

    @OneToMany(mappedBy = "statesArticle", fetch = FetchType.LAZY)
    private List<Article> articles;

    public StatesArticle(String сategory, List<Article> articles) {
        Сategory = сategory;
        this.articles = articles;
    }
}

