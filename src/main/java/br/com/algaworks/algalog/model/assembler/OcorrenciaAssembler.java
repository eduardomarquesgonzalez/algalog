package br.com.algaworks.algalog.model.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import br.com.algaworks.algalog.model.Ocorrencia;
import br.com.algaworks.algalog.model.dto.OcorrenciaResponse;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class OcorrenciaAssembler {
	
	private ModelMapper mapper;
	
	public OcorrenciaResponse toModel(Ocorrencia ocorrencia) {
		return mapper.map(ocorrencia, OcorrenciaResponse.class);
	}
	
	public List<OcorrenciaResponse>toCollectionModel(List<Ocorrencia> ocorrencias){
		return ocorrencias.stream()
				.map(this::toModel)
				.collect(Collectors.toList());
	}

}
