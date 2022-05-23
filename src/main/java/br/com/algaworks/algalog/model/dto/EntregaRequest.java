package br.com.algaworks.algalog.model.dto;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EntregaRequest {
	
	@NotNull
	@Valid
	private ClienteIdRequest cliente;
	
	@NotNull
	@Valid
	private DestinatarioRequest destinatario;

	@NotNull

	private BigDecimal taxa;
	

}
