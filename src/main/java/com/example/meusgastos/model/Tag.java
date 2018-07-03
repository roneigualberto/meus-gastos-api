package com.example.meusgastos.model;

import static javax.persistence.GenerationType.SEQUENCE;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tag")
@SequenceGenerator(name = "tag_sg", sequenceName = "tag_seq", allocationSize = 1)
public class Tag {

	@Id
	@GeneratedValue(generator = "tag_sg", strategy = SEQUENCE)
	private Long id;

	@Column(name = "nome", nullable = false, length = 20)
	private String nome;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
