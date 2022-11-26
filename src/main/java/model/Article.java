package model;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Data
@NoArgsConstructor
@Entity(name = "Article")
@Table(name = "articles")
public class Article extends AbstractObject {
    @Column
    private String name;

    @Column
    private int countPages;

    @Column
    private int countVisits;

    @Column
    private String pictureRef;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "state_id")
    private StatesArticle statesArticle;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private CategoriesArticle categoriesArticle;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "article_users",
            joinColumns = { @JoinColumn(name = "article_id") },
            inverseJoinColumns = { @JoinColumn(name = "user_id") })
    List<User> users;

    public Article(String name, int countPages, int countVisits, String pictureRef, StatesArticle statesArticle, CategoriesArticle categoriesArticle) {
        this.name = name;
        this.countPages = countPages;
        this.countVisits = countVisits;
        this.pictureRef = pictureRef;
        this.statesArticle = statesArticle;
        this.categoriesArticle = categoriesArticle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Article)) return false;
        Article article = (Article) o;
        return Objects.equals(getId(), article.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Article{" +
                "name='" + name + '\'' +
                ", countPages=" + countPages +
                ", countVisits=" + countVisits +
                ", pictureRef='" + pictureRef + '\'' +
                '}';
    }
}
