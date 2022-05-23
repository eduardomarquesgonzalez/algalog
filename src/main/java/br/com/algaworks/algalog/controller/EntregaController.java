package br.com.algaworks.algalog.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.algaworks.algalog.model.Entrega;
import br.com.algaworks.algalog.model.assembler.EntregaAssembler;
import br.com.algaworks.algalog.model.dto.EntregaRequest;
import br.com.algaworks.algalog.model.dto.EntregaResponse;
import br.com.algaworks.algalog.repository.EntregaRespository;
import br.com.algaworks.algalog.service.FinalizacaoEntregaService;
import br.com.algaworks.algalog.service.SolicitacaoEntregaService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas")
public class EntregaController {

	private SolicitacaoEntregaService solicitacaoEntregaService;
	private FinalizacaoEntregaService finalizacaoEntregaService;

	private EntregaRespository entregaRespository;

//	private ModelMapper mapper;
	private EntregaAssembler entregaAssembler;
	
	@PutMapping("/{entregaId}/finalizacao")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void finalizar(@PathVariable Long entregaId) {
		finalizacaoEntregaService.finalizar(entregaId);
	}

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public EntregaResponse solicitar(@Valid @RequestBody EntregaRequest entregaRequest) {
		Entrega novaEntrega = entregaAssembler.toEntity(entregaRequest);
		Entrega entregaSolicitada = solicitacaoEntregaService.solicitar(novaEntrega);
		
		return entregaAssembler.toModel(entregaSolicitada);
	}

	@GetMapping
	public List<EntregaResponse> listar() {
		return entregaAssembler.toCollectionModel(entregaRespository.findAll());
	}

	@GetMapping("/{entregaId}")
	public ResponseEntity<EntregaResponse> buscar(@PathVariable Long entregaId) {
		return entregaRespository.findById(entregaId)
				.map(entrega-> ResponseEntity.ok(entregaAssembler.toModel(entrega)))
				.orElse(ResponseEntity.notFound().build());
	}

}
