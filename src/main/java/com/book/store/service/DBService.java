package com.book.store.service;

import com.book.store.domain.Categoria;
import com.book.store.domain.Livro;
import com.book.store.repositories.CategoriaRepository;
import com.book.store.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {


    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private LivroRepository livroRepository;

    public void instanciaBaseDeDados() {
        Categoria c1 = new Categoria(null, "Informática", "Livro de T.I");
        Categoria c2 = new Categoria(null, "Ficção Científica", "Ficção Científica");
        Categoria c3 = new Categoria(null, "Biografias", "Livros de Biografia");

        Livro l1 = new Livro(null, "Clean Code", "Robert Martin", "Lorem ipsum", c1);
        Livro l2 = new Livro(null, "Engenharia de Software", "Louis V. Gerstner", "Lorem ipsum", c1);
        Livro l3 = new Livro(null, "The Time Machine", "H. G. Wells", "Lorem ipsum", c1);
        Livro l4 = new Livro(null, "I, Robot", "Isaac Asimov", "Lorem ipsum", c1);
        Livro l5 = new Livro(null, "The War Of The Worlds", "H. G. Wells", "Lorem ipsum", c1);

        c1.getLivros().addAll(Arrays.asList(l1, l2));
        c2.getLivros().addAll(Arrays.asList(l3, l4, l5));

        categoriaRepository.saveAll(Arrays.asList(c1, c2, c3));
        livroRepository.saveAll(Arrays.asList(l1, l2, l3, l4, l5));
    }
}
