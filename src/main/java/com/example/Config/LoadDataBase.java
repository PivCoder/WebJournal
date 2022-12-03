package com.example.Config;

import com.example.Service.*;
import com.example.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class LoadDataBase {
    /*private static final Logger log = LoggerFactory.getLogger(LoadDataBase.class);

    @Bean
    CommandLineRunner initDataBase(UserImplement userImplement, AuthorizationServiceImplement authorizationServiceImplement){
        UserType userType = new UserType("type2");
        Authorization authorization = new Authorization("login1", "pass");
        User user = new User("name", "surname", "patr", 15.0,
                "/picture.png");
        user.setUserType(userType);
        user.setAuthorization(authorization);

        return args -> {
            log.info("Preloading " + userImplement.addUser(user));
        };
    }*/
}
