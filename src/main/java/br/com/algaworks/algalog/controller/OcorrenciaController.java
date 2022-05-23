package br.com.algaworks.algalog.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.algaworks.algalog.model.Entrega;
import br.com.algaworks.algalog.model.Ocorrencia;
import br.com.algaworks.algalog.model.assembler.OcorrenciaAssembler;
import br.com.algaworks.algalog.model.dto.OcorrenciaRequest;
import br.com.algaworks.algalog.model.dto.OcorrenciaResponse;
import br.com.algaworks.algalog.service.BuscaEntregaService;
import br.com.algaworks.algalog.service.RegistroOcorrenciaService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas/{entregaId}/ocorrencias")
public class OcorrenciaController {
	
	
	private RegistroOcorrenciaService registroOcorrenciaService;
	private OcorrenciaAssembler ocorrenciaAssembler;
	private BuscaEntregaService buscaEntregaService;
	
	@ResponseStatus(value = HttpStatus.CREATED)
	@PostMapping
	public OcorrenciaResponse registrar(@PathVariable Long entregaId, @Valid @RequestBody OcorrenciaRequest ocorrenciaRequest) {
		Ocorrencia ocorreciaRegistrada = registroOcorrenciaService.registrar(entregaId, ocorrenciaRequest.getDescricao());
		
		return ocorrenciaAssembler.toModel(ocorreciaRegistrada);
	}
	
	@GetMapping
	public List<OcorrenciaResponse> listar(@PathVariable Long entregaId){
		Entrega entrega = buscaEntregaService.buscar(entregaId);
		return ocorrenciaAssembler.toCollectionModel(entrega.getOcorrencias());
		
	}

}
