package com.book.store.config;

import com.book.store.service.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig {

    @Autowired
    private DBService dbService;

    @Bean
    public String instaciaBaseDeDados() {
        String teste = "";
        dbService.instanciaBaseDeDados();
        return teste;
    }

}
