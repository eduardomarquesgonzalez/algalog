package br.com.algaworks.algalog.controller;

import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.algaworks.algalog.model.Entrega;
import br.com.algaworks.algalog.model.dto.DestinatarioResponse;
import br.com.algaworks.algalog.model.dto.EntregaResponse;
import br.com.algaworks.algalog.repository.EntregaRespository;
import br.com.algaworks.algalog.service.SolicitacaoEntregaService;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas")
public class EntregaController {

	private SolicitacaoEntregaService solicitacaoEntregaService;

	private EntregaRespository entregaRespository;

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public Entrega solicitar(@Valid @RequestBody Entrega entrega) {
		return solicitacaoEntregaService.solicitar(entrega);
	}

	@GetMapping
	public List<Entrega> listar() {
		return entregaRespository.findAll();
	}

	@GetMapping("/{entregaId}")
	public ResponseEntity<EntregaResponse> buscar(@PathVariable Long entregaId) {
		return entregaRespository.findById(entregaId)
				.map(entrega -> {
					EntregaResponse response = new EntregaResponse();
					response.setId(entrega.getId());
					response.setNomeCliente(entrega.getCliente().getNome());
					response.setDestinatario(new DestinatarioResponse());
					response.getDestinatario().setNome(entrega.getDestinatario().getNome());
					response.getDestinatario().setLogradouro(entrega.getDestinatario().getLogradouro());
					response.getDestinatario().setNumero(entrega.getDestinatario().getNumero());
					response.getDestinatario().setBairro(entrega.getDestinatario().getBairro());
					response.setTaxa(entrega.getTaxa());
					response.setTaxa(entrega.getTaxa());
					response.setStatus(entrega.getStatus());
					response.setDataPedido(entrega.getDataPedido());
					response.setDataFinalizacao(entrega.getDataFinalizacao());
					
					return ResponseEntity.ok(response);
		
				})
				.orElse(ResponseEntity.notFound().build());
	}

}
