package com.book.store.controller;

import com.book.store.domain.Livro;
import com.book.store.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping("/{id}")
    public ResponseEntity<Livro> findById(@PathVariable Long id) {
        var livro = livroService.findById(id);
        return ResponseEntity.ok().body(livro);
    }

}
