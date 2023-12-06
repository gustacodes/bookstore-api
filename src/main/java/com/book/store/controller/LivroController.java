package com.book.store.controller;

import com.book.store.domain.Livro;
import com.book.store.dtos.LivroDTO;
import com.book.store.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping
    public ResponseEntity<List<LivroDTO>> findAll(@RequestParam(value = "categoria", defaultValue = "0") Long id) {
        List<Livro> livros = livroService.findAll(id);
        List<LivroDTO> livroDTO = livros.stream().map(obj -> new LivroDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(livroDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> findById(@PathVariable Long id) {
        var livro = livroService.findById(id);
        return ResponseEntity.ok().body(livro);
    }

}
