package com.example.Service;

import com.example.model.StatesArticle;

import java.util.List;
import java.util.Optional;

public interface StatesArticleService {
    StatesArticle addStatesArticle(StatesArticle statesArticle);
    void deleteStatesArticle(long id);
    Optional<StatesArticle> getStatesArticleById(long id);
    StatesArticle editStatesArticle(StatesArticle statesArticle);
    List<StatesArticle> getAllStatesArticle();
}
