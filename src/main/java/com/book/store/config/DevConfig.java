package com.book.store.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DevConfig {

    @Autowired
    private DBConfig dbConfig;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String strategy;

    @Bean
    public Boolean instanciaBaseDedados() {
        if(strategy.equals("create")) {
            dbConfig.instanciaBaseDeDados();
        }
        return false;
    }

}
