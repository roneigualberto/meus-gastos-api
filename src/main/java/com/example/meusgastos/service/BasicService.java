package com.example.meusgastos.service;

import java.io.Serializable;
import java.util.List;

public interface BasicService<T, ID extends Serializable> {
	
	
	List<T> findAll();
	T findOne(ID id);
	T save(T entity);
	T update(T entity);
	void delete(ID id);

}
