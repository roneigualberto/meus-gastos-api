package com.example.meusgastos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.meusgastos.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
