package com.gacademico.services;

import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import com.gacademico.dao.AdministradorDAO;
import com.gacademico.entities.Administrador;
import com.gacademico.util.TransacionalCdi;

public class AdministradorService implements Serializable {
	
	private static final long serialVersionUID = 1516706606233354659L;
	
	@Inject
	private AdministradorDAO administradorDAO;
	
	@TransacionalCdi
	public void save(Administrador adm) throws DacaServiceException {
		this.administradorDAO.save(adm);
	}
	
	@TransacionalCdi
	public Administrador update(Administrador adm) throws DacaServiceException {
		return this.administradorDAO.update(adm);
	}
	
	@TransacionalCdi
	public void delete(Administrador adm) throws DacaServiceException {
		this.administradorDAO.delete(adm);
	}
	
	public Administrador getByID(Long idAdm) throws DacaServiceException {
		return this.administradorDAO.getByID(idAdm);
	}
	
	public List<Administrador> getAll() throws DacaServiceException {
		return this.administradorDAO.getAll();
	}
	
}
