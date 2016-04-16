package com.gacademico.daca;

public class DacaException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7669751088704144947L;

	public DacaException(String mensagem) {
		super(mensagem);
	}

	public DacaException(String mensagem, Throwable throwable) {
		super(mensagem, throwable);
	}

}
