package model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

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
    private СategoriesArticle categoriesArticle;

    @Column(name = "Количество_Посещений")
    private int countVisits;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Article)) return false;

        Article article = (Article) o;

        if (countPages != article.countPages) return false;
        if (countVisits != article.countVisits) return false;
        if (!Objects.equals(name, article.name)) return false;
        if (!Objects.equals(statesArticle, article.statesArticle))
            return false;
        if (!Objects.equals(categoriesArticle, article.categoriesArticle)) return false;
        if (!Objects.equals(pictureRef, article.pictureRef)) return false;
        if (!Objects.equals(bookmarks, article.bookmarks)) return false;
        return Objects.equals(histories, article.histories);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + countPages;
        result = 31 * result + (statesArticle != null ? statesArticle.hashCode() : 0);
        result = 31 * result + (categoriesArticle != null ? categoriesArticle.hashCode() : 0);
        result = 31 * result + countVisits;
        result = 31 * result + (pictureRef != null ? pictureRef.hashCode() : 0);
        result = 31 * result + (bookmarks != null ? bookmarks.hashCode() : 0);
        result = 31 * result + (histories != null ? histories.hashCode() : 0);
        return result;
    }

    @Column(name = "Ссылка_Картинка")
    private String pictureRef;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "Закладки",
            joinColumns = { @JoinColumn(name = "Статьи_Id") },
            inverseJoinColumns = { @JoinColumn(name = "Пользователя_Id") })
    private Set<User> bookmarks = new HashSet<User>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "Истории",
            joinColumns = { @JoinColumn(name = "Статьи_Id") },
            inverseJoinColumns = { @JoinColumn(name = "Пользователя_Id") })
    private Set<User> histories = new HashSet<User>();

    @Override
    public String toString() {
        return "Article{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                ", countPages=" + countPages +
                ", countVisits=" + countVisits +
                ", pictureRef='" + pictureRef + '\'' +
                '}';
    }
}
