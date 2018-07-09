package com.example.meusgastos.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.example.meusgastos.model.TipoLancamento;

public class LancamentoDTO {

	private Long id;

	@NotNull
	private TipoLancamento tipo;

	@NotNull
	private String descricao;

	@NotNull
	private BigDecimal valor;

	@NotNull
	private Date dataRealizacao;

	@NotNull
	private CategoriaDTO categoria;

	@NotNull
	private String pago;

	private List<TagDTO> tags;

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

	public CategoriaDTO getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaDTO categoria) {
		this.categoria = categoria;
	}

	public String getPago() {
		return pago;
	}

	public void setPago(String pago) {
		this.pago = pago;
	}

	public List<TagDTO> getTags() {
		return tags;
	}

	public void setTags(List<TagDTO> tags) {
		this.tags = tags;
	}

}
