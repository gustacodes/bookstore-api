package com.book.store.repositories;

import com.book.store.domain.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Long> {

    @Query("SELECT obj FROM Livro obj WHERE obj.categoria.id = :id ORDER BY titulo")
    List<Livro> findAllByCategoria(@Param(value = "id") Long id);

}
