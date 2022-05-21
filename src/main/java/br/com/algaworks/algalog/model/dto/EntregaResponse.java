package br.com.algaworks.algalog.model.dto;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import br.com.algaworks.algalog.model.enums.StatusEntra;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EntregaResponse {

	private Long id;
	private String  nomeCliente;
	private DestinatarioResponse destinatario;
	private BigDecimal taxa;
	private StatusEntra status;
	private OffsetDateTime dataPedido;
	private OffsetDateTime dataFinalizacao;

}
