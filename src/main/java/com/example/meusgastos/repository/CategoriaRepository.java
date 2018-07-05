package com.example.meusgastos.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.meusgastos.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

	Page<Categoria> findByNomeLike(String nome, Pageable pageable);

}
