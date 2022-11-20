package com.example.webjournalspring_v2;

import Repositoryes.UserRepository;
import Repositoryes.UserTypeRepository;
import Repositoryes.UserTypeServiceImpl;
import model.User;
import model.UserType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "Repositoryes")
@EntityScan("model")
public class WebJournalSpringV2Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(WebJournalSpringV2Application.class, args);
        UserTypeRepository repository = context.getBean(UserTypeRepository.class);

        //UserRepository repository2 = context.getBean(UserRepository.class);

        UserType userType1 = new UserType("нннн");
        repository.save(userType1);

        //User user1 = new User("и","ф","о", 0.2,"ссылк");
        //user1.setUserType(userType1);
        //System.out.println(user1.getId());
        //repository2.save(user1);



//        UserTypeServiceImpl utsi = new UserTypeServiceImpl();
//        utsi.saveUserType(userType1);



    }
}
