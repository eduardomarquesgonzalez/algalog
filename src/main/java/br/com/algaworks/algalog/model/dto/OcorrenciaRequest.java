package br.com.algaworks.algalog.model.dto;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OcorrenciaRequest {
	
	@NotBlank
	private String descricao;

}
