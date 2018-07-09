package com.example.meusgastos.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public class BasicAdapterService<T, ID extends Serializable, R extends JpaRepository<T, ID>>
		implements BasicService<T, ID> {

	protected R repository;

	BasicAdapterService(R repository) {
		this.repository = repository;
	}

	@Override
	public List<T> findAll() {
		return repository.findAll();
	}

	@Override
	public Optional<T> findById(ID id) {

		return repository.findById(id);
	}

	@Override
	@Transactional
	public T save(T entity) {
		return this.repository.saveAndFlush(entity);
	}

	@Override
	public T update(T entity) {
		return this.repository.saveAndFlush(entity);
	}

	@Override
	public void delete(ID id) {
		this.repository.deleteById(id);
	}

	@Override
	public Page<T> findAll(Pageable pageable) {
		return this.repository.findAll(pageable);
	}

}
