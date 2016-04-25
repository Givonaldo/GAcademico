package com.gacademico.services;

import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import com.gacademico.dao.PeriodoDAO;
import com.gacademico.entities.Periodo;
import com.gacademico.util.TransacionalCdi;

public class PeriodoService implements Serializable {

	private static final long serialVersionUID = 3106865992163526260L;
	
	@Inject
	private PeriodoDAO periodoDAO;
	
	@TransacionalCdi
	public void save(Periodo periodo) throws DacaServiceException {
		this.periodoDAO.save(periodo);
	}
	
	@TransacionalCdi
	public Periodo update(Periodo periodo) throws DacaServiceException {
		return this.periodoDAO.update(periodo);
	}
	
	@TransacionalCdi
	public void delete(Periodo periodo) throws DacaServiceException {
		this.periodoDAO.delete(periodo);
	}
	
	public Periodo getByID(Long idPeriodo) throws DacaServiceException {
		return this.periodoDAO.getByID(idPeriodo);
	}
	
	public List<Periodo> getAll() throws DacaServiceException {
		return this.periodoDAO.getAll();
	}

}