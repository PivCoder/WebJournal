package Repositoryes;

import model.CategoriesArticle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriesArticleRepository extends JpaRepository<CategoriesArticle, Integer> {
}
