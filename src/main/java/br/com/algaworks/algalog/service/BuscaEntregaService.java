package br.com.algaworks.algalog.service;

import org.springframework.stereotype.Service;

import br.com.algaworks.algalog.model.Entrega;
import br.com.algaworks.algalog.model.exception.EntidadeNaoEncontradaException;
import br.com.algaworks.algalog.repository.EntregaRespository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BuscaEntregaService {

	private EntregaRespository entregaRespository;

	public Entrega buscar(Long entregaId) {
		return entregaRespository.findById(entregaId)
				.orElseThrow(()-> new EntidadeNaoEncontradaException("Entrega não encontrada"));
		
	}
}

