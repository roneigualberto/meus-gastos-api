package com.example.meusgastos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.meusgastos.model.Lancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {

}
