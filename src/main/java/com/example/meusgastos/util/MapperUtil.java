package com.example.meusgastos.util;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

public class MapperUtil {

	private static final ModelMapper MAPPER = new ModelMapper();

	public static <S, D> List<D> mapList(List<S> sourceList, Class<D> destinationType) {

		return sourceList.stream().map(item -> map(item, destinationType)).collect(Collectors.toList());

	}

	public static <S, D> D map(S source, Class<D> destinationType) {
		return MAPPER.map(source, destinationType);
	}

}
