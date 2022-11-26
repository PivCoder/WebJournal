package com.example.Service.Implements;

import com.example.Repositoryes.StatesArticleRepository;
import com.example.Service.StatesArticleService;
import com.example.model.StatesArticle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatesArticleImplement implements StatesArticleService {

    @Autowired
    StatesArticleRepository statesArticleRepository;

    @Override
    public StatesArticle addStatesArticle(StatesArticle statesArticle) {
        StatesArticle savedStateArticle = statesArticleRepository.saveAndFlush(statesArticle);
        return savedStateArticle;
    }

    @Override
    public void deleteStatesArticle(long id) {
        statesArticleRepository.deleteById(id);
    }

    @Override
    public Optional<StatesArticle> getStatesArticleById(long id) {
        return statesArticleRepository.findById(id);
    }

    @Override
    public StatesArticle editStatesArticle(StatesArticle statesArticle) {
        return statesArticleRepository.saveAndFlush(statesArticle);
    }

    @Override
    public List<StatesArticle> getAllStatesArticle() {
        return statesArticleRepository.findAll();
    }
}
