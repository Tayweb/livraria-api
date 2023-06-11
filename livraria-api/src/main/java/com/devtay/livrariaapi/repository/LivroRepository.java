package com.devtay.livrariaapi.repository;

import com.devtay.livrariaapi.domain.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
