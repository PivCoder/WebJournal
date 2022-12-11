package com.example.Config;

import com.example.Service.*;
import com.example.model.*;
import com.example.model.Enums.UserTypes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//@Configuration
public class LoadDataBase {
    /*private static final Logger log = LoggerFactory.getLogger(LoadDataBase.class);

    @Bean
    CommandLineRunner initDataBase(UserImplement userImplement, AuthorizationServiceImplement authorizationServiceImplement){
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        Authorization authorization = new Authorization("login1", encoder.encode("pass"));
        User user = new User("name", "surname", "patr", 15.0,
                "/picture.png", UserTypes.ROLE_USER);
        user.setAuthorization(authorization);

        return args -> {
            log.info("Preloading " + userImplement.addUser(user));
        };
    }*/
}
