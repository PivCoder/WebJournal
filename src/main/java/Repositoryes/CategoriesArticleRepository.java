package Repositoryes;


import model.СategoriesArticle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriesArticleRepository extends CrudRepository<СategoriesArticle, Integer> {
}
