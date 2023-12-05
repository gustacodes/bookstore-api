package com.book.store.service;

import com.book.store.domain.Categoria;
import com.book.store.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria findById(Long id) {
        Optional<Categoria> buscarCategoria = categoriaRepository.findById(id);
        return buscarCategoria.orElse(null);
    }

}
