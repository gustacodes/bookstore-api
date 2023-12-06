package com.book.store.dtos;

import com.book.store.domain.Categoria;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

public class CategoriaDTO {

    private Long id;
    @NotEmpty(message = "Campo nome é obrigatório")
    @Length(min = 3, max = 100, message = "Mínimo de 3 caractéres requerido e no máximo 100")
    private String nome;

    @NotEmpty(message = "Campo descrição é obrigatório")
    @Length(min = 3, max = 100, message = "Mínimo de 3 caractéres requerido e no máximo 200")
    private String descricao;

    public CategoriaDTO() {

    }

    public CategoriaDTO(Categoria categoria) {
        this.id = categoria.getId();
        this.nome = categoria.getNome();
        this.descricao = categoria.getDescricao();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
