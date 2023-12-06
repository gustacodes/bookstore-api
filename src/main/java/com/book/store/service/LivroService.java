package com.book.store.service;

import com.book.store.domain.Livro;
import com.book.store.exceptions.ObjectNotFoundExceptions;
import com.book.store.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public Livro findById(Long id) {
        Optional<Livro> livro = livroRepository.findById(id);
        return livro.orElseThrow(() -> new ObjectNotFoundExceptions("Livro não encontrado " + Livro.class.getName() + " Id: " + id));
    }

}
