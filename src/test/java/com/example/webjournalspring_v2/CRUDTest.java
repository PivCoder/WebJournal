package com.example.webjournalspring_v2;

import com.example.Service.*;
import com.example.model.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CRUDTest {

    @Autowired
    ArticleServiceImplement articleServiceImplement;

    @Autowired
    AuthorizationServiceImplement authorizationServiceImplement;

    @Autowired
    CategoriesArticleImplement categoriesArticleImplement;

    @Autowired
    StatesArticleImplement statesArticleImplement;

    @Autowired
    UserImplement userImplement;

    @Autowired
    UserTypeImplement userTypeImplement;

    @Test
    void addAllEntities(){
        CategoriesArticle categoriesArticle = new CategoriesArticle("test_category");
        categoriesArticleImplement.addCategoriesArticle(categoriesArticle);

        StatesArticle statesArticle = new StatesArticle("test_state");
        statesArticleImplement.addStatesArticle(statesArticle);

        Article article = new Article("test_article",
                150, 125, "/picture.jpg", statesArticle, categoriesArticle);
        articleServiceImplement.addArticle(article);

        UserType userType = new UserType("test_user_type");
        userTypeImplement.addUserType(userType);

        User user = new User("test_user",
                "test_lastName", "test_patr", 15.0, "/image.jpg", userType);

        Authorization authorization = new Authorization("login_test", "pass");

        user.setAuthorization(authorization);
        authorization.setUser(user);

        userImplement.addUser(user);
        authorizationServiceImplement.addAuthorization(authorization);
    }
}
