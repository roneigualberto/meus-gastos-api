package com.example.meusgastos.model;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "lancamento")
@SequenceGenerator(name = "lancamento_sg", sequenceName = "lancamento_seq", allocationSize = 1)
public class Lancamento implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "lancamento_sg", strategy = SEQUENCE)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_conta")
	private Conta conta;

	@Enumerated(EnumType.STRING)
	@Column(name = "tipo", nullable = false, length = 1)
	private TipoLancamento tipo;

	@Column(name = "descricao", nullable = false, length = 80)
	private String descricao;

	@Column(name = "valor", nullable = false, length = 10, scale = 2)
	private BigDecimal valor;

	@Temporal(TemporalType.DATE)
	@Column(name = "data_realizacao")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dataRealizacao;

	@ManyToOne
	@JoinColumn(name = "id_categoria")
	private Categoria categoria;

	@Column(name = "observacao", length = 255)
	private String observacao;

	@Column(name = "pago", length = 1)
	private String pago;

	@ManyToMany
	@JoinTable(name = "lancamento_tag", joinColumns = { @JoinColumn(name = "id_lancamento") }, inverseJoinColumns = {
			@JoinColumn(name = "id_tag") })
	private List<Tag> tags;

	// @OneToOne
	// private LancamentoAnexo anexo;

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoLancamento getTipo() {
		return tipo;
	}

	public void setTipo(TipoLancamento tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Date getDataRealizacao() {
		return dataRealizacao;
	}

	public void setDataRealizacao(Date dataRealizacao) {
		this.dataRealizacao = dataRealizacao;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getPago() {
		return pago;
	}

	public void setPago(String pago) {
		this.pago = pago;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lancamento other = (Lancamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	/*
	 * public LancamentoAnexo getAnexo() { return anexo; }
	 * 
	 * public void setAnexo(LancamentoAnexo anexo) { this.anexo = anexo; }
	 */

}
