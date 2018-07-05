package com.example.meusgastos.controller;

import org.springframework.data.domain.Page;

import com.example.meusgastos.util.MapperUtil;

public class BaseController {

	protected static <S, D> Page<D> pageAs(Page<S> page, Class<D> destinationType) {

		return page.map(source -> map(source, destinationType));

	}

	protected static <S, D> D map(S source, Class<D> destinationType) {
		return MapperUtil.map(source, destinationType);

	}

}
