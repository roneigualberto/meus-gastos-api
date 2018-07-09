package com.example.meusgastos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.meusgastos.model.Lancamento;
import com.example.meusgastos.repository.LancamentoRepository;

@Service
public class LancamentoServiceImpl extends BasicAdapterService<Lancamento, Long, LancamentoRepository>
		implements LancamentoService {

	@Autowired
	LancamentoServiceImpl(LancamentoRepository repository) {
		super(repository);

	}
	
	
	@Override
	@Transactional(readOnly=false)
	public Lancamento save(Lancamento entity) {
		return repository.saveAndFlush(entity);
	}

}
