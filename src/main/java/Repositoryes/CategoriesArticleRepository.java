package Repositoryes;

import model.CategoriesArticle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriesArticleRepository extends CrudRepository<CategoriesArticle, Integer> {
}
