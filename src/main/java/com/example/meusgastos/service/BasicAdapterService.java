package com.example.meusgastos.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public class BasicAdapterService<T, ID extends Serializable, R extends JpaRepository<T, ID>>
		implements BasicService<T, ID> {

	private R repository;

	BasicAdapterService(R repository) {
		this.repository = repository;
	}

	@Override
	public List<T> findAll() {
		return repository.findAll();
	}

	@Override
	public T findOne(ID id) {
		return this.repository.findOne(id);
	}

	@Override
	public T save(T entity) {
		return this.repository.save(entity);
	}

	@Override
	public T update(T entity) {
		return this.repository.saveAndFlush(entity);
	}

	@Override
	public void delete(ID id) {
		this.repository.delete(id);
	}

	public R getRepository() {
		return repository;
	}

}
