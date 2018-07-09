package com.example.meusgastos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.meusgastos.model.Conta;

public interface ContaRepository extends JpaRepository<Conta, Long> {

}
