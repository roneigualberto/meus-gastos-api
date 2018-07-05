package com.example.meusgastos.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BasicService<T, ID extends Serializable> {

	List<T> findAll();
	
	Page<T> findAll(Pageable pageable);

	Optional<T> findById(ID id);

	T save(T entity);

	T update(T entity);

	void delete(ID id);

}
