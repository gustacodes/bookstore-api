package com.book.store.controller;

import com.book.store.domain.Livro;
import com.book.store.dtos.LivroDTO;
import com.book.store.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @PostMapping
    public ResponseEntity<Livro> create(@RequestParam(value = "categoria", defaultValue = "0") Long id, @RequestBody Livro livro) {
        Livro novoLivro = livroService.create(id, livro);
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/livros/{id}").buildAndExpand(livro.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

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

    @PutMapping("/{id}")
    public ResponseEntity<Livro> update(@PathVariable Long id, @RequestBody Livro livro) {
        Livro newLivro = livroService.update(id, livro);
        return ResponseEntity.ok().body(newLivro);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Livro> updatePatch(@PathVariable Long id, @RequestBody Livro livro) {
        Livro newLivro = livroService.update(id, livro);
        return ResponseEntity.ok().body(newLivro);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        livroService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
