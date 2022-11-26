package com.example.webjournalspring_v2;

import Repositoryes.*;
import model.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "Repositoryes")
@EntityScan("model")
public class WebJournalSpringV2Application {
    static ArticleRepository articleRepository;
    static CategoriesArticleRepository categoriesArticleRepository;
    static StatesArticleRepository statesArticleRepository;
    static UserTypeRepository userTypeRepository;
    static AuthorizationRepository authorizationRepository;
    static UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(WebJournalSpringV2Application.class, args);

        CategoriesArticle categoriesArticle = new CategoriesArticle("category1");
        categoriesArticleRepository.save(categoriesArticle);

        StatesArticle statesArticle = new StatesArticle("state1");
        statesArticleRepository.save(statesArticle);

        Article article = new Article();
        article.setName("name1");
        article.setCountPages(120);
        article.setCountVisits(125);
        article.setPictureRef("/info.png");
        article.setCategoriesArticle(categoriesArticle);
        article.setStatesArticle(statesArticle);
        articleRepository.save(article);


        UserType userType = new UserType("role1");
        User user = new User("name", "lastname", "patr", 10.05, "picture.jpg");
        Authorization authorization = new Authorization();
    }
}
