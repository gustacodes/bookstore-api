package com.book.store.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

import java.util.Objects;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Campo título é obrigatório")
    @Length(min = 3, max = 50, message = "Mínimo de 3 caractéres requerido e no máximo 50")
    private String titulo;
    @NotEmpty(message = "Campo nome do autor é obrigatório")
    @Length(min = 3, max = 50, message = "Mínimo de 3 caractéres requerido e no máximo 50")
    private String nomeAutor;
    @NotEmpty(message = "Campo texto é obrigatório")
    @Length(min = 10, max = 2000000, message = "Mínimo de 3 caractéres requerido e no máximo 2.000.000")
    private String texto;
    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private Categoria categoria;

    public Livro() {

    }

    public Livro(Long id, String titulo, String nomeAutor, String texto, Categoria categoria) {
        this.id = id;
        this.titulo = titulo;
        this.nomeAutor = nomeAutor;
        this.texto = texto;
        this.categoria = categoria;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return Objects.equals(id, livro.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
