package Repositoryes;

import model.StatesArticle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatesArticleRepository extends CrudRepository<StatesArticle, Integer> {
}
