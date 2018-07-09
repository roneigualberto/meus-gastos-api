package com.example.meusgastos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.meusgastos.model.Tag;

public interface TagRepository extends JpaRepository<Tag, Long> {

}
