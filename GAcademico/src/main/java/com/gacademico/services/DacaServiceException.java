package com.gacademico.services;

import com.gacademico.daca.DacaException;

public class DacaServiceException extends DacaException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3082351960302866350L;

	public DacaServiceException(String mensagem) {
		super(mensagem);
	}

	public DacaServiceException(String mensagem, Throwable throwable) {
		super(mensagem, throwable);
	}

}
