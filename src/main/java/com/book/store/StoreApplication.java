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
public class StoreApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private LivroRepository livroRepository;

	public static void main(String[] args) {
		SpringApplication.run(StoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria c1 = new Categoria(null, "Informática", "Livro de T.I");
		Livro l1= new Livro(null, "Clean Code", "Robert Martin", "Lorem ipsum", c1);

		c1.getLivros().addAll(Arrays.asList(l1));

		categoriaRepository.saveAll(Arrays.asList(c1));
		livroRepository.saveAll(Arrays.asList(l1));
	}
}
