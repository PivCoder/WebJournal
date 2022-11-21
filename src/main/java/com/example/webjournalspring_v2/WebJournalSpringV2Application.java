package com.example.webjournalspring_v2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "Repositoryes")
@EntityScan("model")
public class WebJournalSpringV2Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(WebJournalSpringV2Application.class, args);
    }
}
