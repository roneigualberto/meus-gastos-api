package com.example.meusgastos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.meusgastos.model.Categoria;
import com.example.meusgastos.repository.CategoriaRepository;

@Service
@Transactional
public class CategoriaServiceImpl extends BasicAdapterService<Categoria, Long, CategoriaRepository>
		implements CategoriaService {

	@Autowired
	CategoriaServiceImpl(CategoriaRepository repository) {
		super(repository);

	}
	
	

	@Override
	public Page<Categoria> find(String query, Pageable pageable) {
		return this.repository.findByNomeLike(query, pageable);
	}

}
