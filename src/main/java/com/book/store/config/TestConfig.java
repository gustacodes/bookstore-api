package com.book.store.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig {

    @Autowired
    private DBConfig dbConfig;

    @Bean
    public String instaciaBaseDeDados() {
        String teste = "";
        dbConfig.instanciaBaseDeDados();
        return teste;
    }

}
