package br.com.algaworks.algalog.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.algaworks.algalog.model.Entrega;
import br.com.algaworks.algalog.model.Ocorrencia;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class RegistroOcorrenciaService {
	
	private BuscaEntregaService buscaEntregaService;
	
	@Transactional
	public Ocorrencia registrar(Long entregaId, String descricao) {
		Entrega entrega = buscaEntregaService.buscar(entregaId);
		return entrega.adicionarOcorrencia(descricao);
	}

}
