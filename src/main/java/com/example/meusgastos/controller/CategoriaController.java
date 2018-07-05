package com.example.meusgastos.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.meusgastos.dto.CategoriaDTO;
import com.example.meusgastos.model.Categoria;
import com.example.meusgastos.service.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaController extends BaseController {

	@Autowired
	private CategoriaService service;

	@GetMapping
	public Page<CategoriaDTO> search(Pageable pageable) {

		final Page<Categoria> page = service.findAll(pageable);

		return pageAs(page, CategoriaDTO.class);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> get(@PathVariable("id") Long id) {
		Optional<Categoria> opt = service.findById(id);

		if (opt.isPresent()) {
			return ResponseEntity.ok(map(opt.get(), CategoriaDTO.class));
		} else {
			return ResponseEntity.notFound().build();
		}

	}

	@PostMapping
	public ResponseEntity<?> save(@RequestBody @Valid CategoriaDTO dto) {

		Categoria categoria = map(dto, Categoria.class);

		service.save(categoria);

		return get(categoria.getId());
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody @Valid CategoriaDTO dto) {

		Categoria categoria = map(dto, Categoria.class);

		categoria.setId(id);

		service.update(categoria);

		return get(categoria.getId());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {

		Optional<Categoria> opt = service.findById(id);

		if (opt.isPresent()) {
			service.delete(id);
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}

	}

}
