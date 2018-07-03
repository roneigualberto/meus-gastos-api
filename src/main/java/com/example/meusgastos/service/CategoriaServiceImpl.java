package com.example.meusgastos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.meusgastos.model.Categoria;
import com.example.meusgastos.repository.CategoriaRepository;

@Service
public class CategoriaServiceImpl extends BasicAdapterService<Categoria, Long, CategoriaRepository>
		implements CategoriaService {

	@Autowired
	CategoriaServiceImpl(CategoriaRepository repository) {
		super(repository);

	}

}
