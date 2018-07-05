package com.example.meusgastos.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.meusgastos.model.Categoria;

public interface CategoriaService extends BasicService<Categoria, Long> {
	
	
	Page<Categoria> find(String query, Pageable pageable);
}
