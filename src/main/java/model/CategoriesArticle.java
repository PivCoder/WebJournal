package model;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@Entity
@Table(name = "Категории")
public class CategoriesArticle extends AbstractObject{

    @Column(name = "Категория")
    private String category;

    @OneToMany(mappedBy = "categoriesArticle", fetch = FetchType.LAZY)
    private List<Article> articles;

    public CategoriesArticle(String category, List<Article> articles) {
        this.category = category;
        this.articles = articles;
    }
}
