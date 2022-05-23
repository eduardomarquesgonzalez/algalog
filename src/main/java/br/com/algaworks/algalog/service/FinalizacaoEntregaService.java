package br.com.algaworks.algalog.service;

import org.springframework.stereotype.Service;

import br.com.algaworks.algalog.model.Entrega;
import br.com.algaworks.algalog.model.enums.StatusEntrega;
import br.com.algaworks.algalog.repository.EntregaRespository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class FinalizacaoEntregaService {
	
	private EntregaRespository entregaRespository;
	private BuscaEntregaService buscaEntregaService;
	
	public void finalizar(Long entregaId) {
		Entrega entrega = buscaEntregaService.buscar(entregaId);
		entrega.finalizar();
		
		entrega.setStatus(StatusEntrega.FINALIZADA);
		
		entregaRespository.save(entrega);
	}

}
