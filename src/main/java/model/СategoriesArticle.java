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
@Table(name = "Категории")
public class СategoriesArticle extends AbstractObject{

    @Column(name = "Категория")
    private String Сategory;

    @OneToMany(mappedBy = "categoriesArticle", fetch = FetchType.LAZY)
    private List<Article> articles;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof СategoriesArticle)) return false;

        СategoriesArticle that = (СategoriesArticle) o;

        if (!Objects.equals(Сategory, that.Сategory)) return false;
        return Objects.equals(articles, that.articles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), Сategory, articles);
    }

    @Override
    public String toString() {
        return "СategoriesArticle{" +
                "id=" + getId() +
                ", Сategory='" + Сategory +
                '}';
    }
}
