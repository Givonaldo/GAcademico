package com.gacademico.dao;

import com.gacademico.daca.DacaException;


public class DacaPersistenciaException extends DacaException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1780243892137781599L;

	public DacaPersistenciaException(String mensagem) {
		super(mensagem);
	}

	public DacaPersistenciaException(String mensagem, Throwable throwable) {
		super(mensagem, throwable);
	}

}
