package com.book.store;

import com.book.store.domain.Categoria;
import com.book.store.domain.Livro;
import com.book.store.repositories.CategoriaRepository;
import com.book.store.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class StoreApplication {
	public static void main(String[] args) {
		SpringApplication.	run(StoreApplication.class, args);
	}

}
