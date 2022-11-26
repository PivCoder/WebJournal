package model;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Data
@NoArgsConstructor
@Entity(name = "State")
@Table(name = "states")
public class StatesArticle extends AbstractObject{

    @Column
    private String state;

    @OneToMany(mappedBy = "statesArticle", fetch = FetchType.LAZY)
    private List<Article> articles;

    public StatesArticle(String state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StatesArticle)) return false;
        StatesArticle statesArticle = (StatesArticle) o;
        return Objects.equals(getId(), statesArticle.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "StatesArticle{" +
                "state='" + state + '\'' +
                '}';
    }
}

