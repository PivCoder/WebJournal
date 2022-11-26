package com.example.Repositoryes;

import com.example.model.StatesArticle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatesArticleRepository extends JpaRepository<StatesArticle, Long> {
}
