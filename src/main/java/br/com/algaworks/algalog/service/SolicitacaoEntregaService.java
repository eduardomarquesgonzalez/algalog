package br.com.algaworks.algalog.service;

import java.time.OffsetDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.algaworks.algalog.model.Cliente;
import br.com.algaworks.algalog.model.Entrega;
import br.com.algaworks.algalog.model.enums.StatusEntrega;
import br.com.algaworks.algalog.repository.EntregaRespository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class SolicitacaoEntregaService {
	
	private EntregaRespository repository;
	private CatalagoClienteService catalagoClienteService;
	
	@Transactional
	public Entrega solicitar(Entrega entrega) {
		Cliente cliente = catalagoClienteService.buscar(entrega.getCliente().getId());
		entrega.setCliente(cliente);
		entrega.setStatus(StatusEntrega.PENDENTE);
		entrega.setDataPedido(OffsetDateTime.now());

		return repository.save(entrega);
		
	}
	

}
