package com.example.meusgastos.controller;

import java.net.URI;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.meusgastos.dto.ResponseDTO;
import com.example.meusgastos.util.MapperUtil;

public class BaseController {

	protected static <S, D> Page<D> pageAs(Page<S> page, Class<D> destinationType) {

		return page.map(source -> map(source, destinationType));

	}

	protected static <S, D> D map(S source, Class<D> destinationType) {
		return MapperUtil.map(source, destinationType);
	}

	protected static <S, D> ResponseEntity<?> mapAsResponse(S source, Class<D> destinationType) {

		return ResponseEntity.ok(map(source, destinationType));
	}

	public ResponseEntity<?> toResponse(String mensagem) {
		return ResponseEntity.ok(new ResponseDTO(mensagem));
	}

	public ResponseEntity<?> created(URI location, String msg) {
		return ResponseEntity.created(location).body(new ResponseDTO(msg));
	}

	public URI toUri(UriComponentsBuilder uriBuilder, String path, Object... params) {
		return uriBuilder.path(path).buildAndExpand(params).toUri();
	}

}
