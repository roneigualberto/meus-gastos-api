package com.example.meusgastos.dto;

public class ResponseDTO {

	private String id;
	private String mensagem;
	private Object data;

	public ResponseDTO(String id, String mensagem, Object data) {
		super();
		this.id = id;
		this.mensagem = mensagem;
		this.data = data;
	}

	public ResponseDTO(String mensagem) {
		this(null, mensagem, null);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
