package br.com.algaworks.algalog.exceptionHandler;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CampoError {

	private String nome;
	private String mensagem;

}
