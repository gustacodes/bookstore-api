package com.book.store.repositories;

import com.book.store.domain.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository  extends JpaRepository<Livro, Long> {

}
