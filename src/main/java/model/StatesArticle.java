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
@Table(name = "Состояния")
public class StatesArticle extends AbstractObject{

    @Column(name = "Состояние")
    private String Сategory;

    @OneToMany(mappedBy = "statesArticle", fetch = FetchType.LAZY)
    private List<Article> articles;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StatesArticle)) return false;

        StatesArticle that = (StatesArticle) o;

        if (!Objects.equals(Сategory, that.Сategory)) return false;
        return Objects.equals(articles, that.articles);
    }

    @Override
    public int hashCode() {
        int result = Сategory != null ? Сategory.hashCode() : 0;
        result = 31 * result + (articles != null ? articles.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "StatesArticle{" +
                "id=" + getId() +
                ", Сategory='" + Сategory + '\'' +
                '}';
    }
}

