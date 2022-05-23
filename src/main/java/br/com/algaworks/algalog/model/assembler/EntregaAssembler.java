package br.com.algaworks.algalog.model.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import br.com.algaworks.algalog.model.Entrega;
import br.com.algaworks.algalog.model.dto.EntregaRequest;
import br.com.algaworks.algalog.model.dto.EntregaResponse;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class EntregaAssembler {
	
	private ModelMapper mapper;
	
	public EntregaResponse toModel(Entrega entrega) {
		
		return mapper.map(entrega, EntregaResponse.class);
		
	}
	
	public List<EntregaResponse> toCollectionModel(List<Entrega> entregas){
		return entregas.stream()
				.map(this::toModel)
				.collect(Collectors.toList());
	}
	
	public Entrega toEntity(EntregaRequest request) {
		return mapper.map(request, Entrega.class);
	}

}
