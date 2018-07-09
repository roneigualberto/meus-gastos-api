package com.example.meusgastos.controller;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.meusgastos.dto.LancamentoDTO;
import com.example.meusgastos.dto.ResponseDTO;
import com.example.meusgastos.model.Lancamento;
import com.example.meusgastos.service.LancamentoService;;

@RestController
@RequestMapping(LancamentoController.BASE_URL)
public class LancamentoController extends BaseController {

	public static final String BASE_URL = "/lancamentos";

	@Autowired
	private LancamentoService service;

	@GetMapping
	public Page<LancamentoDTO> search(Pageable pageable) {

		final Page<Lancamento> page = service.findAll(pageable);

		return pageAs(page, LancamentoDTO.class);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> get(@PathVariable("id") Long id) {
		final Optional<Lancamento> opt = service.findById(id);

		if (opt.isPresent()) {
			return mapAsResponse(opt.get(), LancamentoDTO.class);
		} else {
			return notFound();
		}

	}

	private ResponseEntity<?> notFound() {
		ResponseDTO body = new ResponseDTO("Lançamento não encontrado");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
	}

	@PostMapping
	public ResponseEntity<?> save(@RequestBody @Valid LancamentoDTO dto, UriComponentsBuilder uriBuilder) {

		final Lancamento lancamento = map(dto, Lancamento.class);

		service.save(lancamento);

		final URI location = toUri(uriBuilder, BASE_URL + "/{id}", lancamento.getId());

		return created(location, "Lançamento salvo com sucesso");

	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody @Valid LancamentoDTO dto) {

		Lancamento lancamento = map(dto, Lancamento.class);

		lancamento.setId(id);

		service.update(lancamento);

		return toResponse("Lançamento atualizado com sucesso");
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {

		Optional<Lancamento> opt = service.findById(id);

		if (opt.isPresent()) {
			service.delete(id);
			return toResponse("Lançamento excluido com sucesso");
		} else {
			return notFound();
		}

	}

}
