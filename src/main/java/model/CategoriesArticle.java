package model;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Data
@NoArgsConstructor
@Entity(name = "Category")
@Table(name = "categories")
public class CategoriesArticle extends AbstractObject{

    @Column
    private String category;

    @OneToMany(mappedBy = "categoriesArticle", fetch = FetchType.LAZY)
    private List<Article> articles;

    public CategoriesArticle(String category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CategoriesArticle)) return false;
        CategoriesArticle categoriesArticle = (CategoriesArticle) o;
        return Objects.equals(getId(), categoriesArticle.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "CategoriesArticle{" +
                "category='" + category + '\'' +
                '}';
    }
}
