package br.com.algaworks.algalog.model.dto;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteIdRequest {
	
	@NotNull
	private Long id;

}
