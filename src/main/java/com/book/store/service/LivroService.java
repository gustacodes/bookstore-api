package com.book.store.service;

import com.book.store.domain.Livro;
import com.book.store.exceptions.ObjectNotFoundExceptions;
import com.book.store.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private CategoriaService categoriaService;

    public Livro findById(Long id) {
        Optional<Livro> livro = livroRepository.findById(id);
        return livro.orElseThrow(() -> new ObjectNotFoundExceptions("Livro não encontrado " + Livro.class.getName() + " Id: " + id));
    }

    public List<Livro> findAll(Long id) {
        categoriaService.findById(id);
        return livroRepository.findAllByCategoria(id);
    }

    public Livro update(Long id, Livro livro) {
        Livro newLivro = findById(id);
        updateData(newLivro, livro);
        return livroRepository.save(newLivro);
    }

    private void updateData(Livro newLivro, Livro livro) {
        newLivro.setTitulo(livro.getTitulo());
        newLivro.setTexto(livro.getTexto());
        newLivro.setNomeAutor(livro.getNomeAutor());
    }

}
