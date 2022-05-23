package br.com.algaworks.algalog.model.exception;

public class EntidadeNaoEncontradaException extends NegocioException{
	private static final long serialVersionUID = 1L;
	
	public EntidadeNaoEncontradaException(String message) {
		super(message);
	}


}
