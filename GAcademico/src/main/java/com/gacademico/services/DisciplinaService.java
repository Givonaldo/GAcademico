package com.gacademico.services;

import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import com.gacademico.dao.DacaPersistenciaException;
import com.gacademico.dao.DisciplinaDAO;
import com.gacademico.entities.Disciplina;
import com.gacademico.util.TransacionalCdi;

/**
 * 
 * @author Gilvonaldo
 *
 */
public class DisciplinaService implements Serializable {
	
	private static final long serialVersionUID = -8179646083592206226L;
	
	@Inject
	private DisciplinaDAO disciplinaDAO;
	
	@TransacionalCdi
	public void save(Disciplina disciplina) throws DacaServiceException {
		this.disciplinaDAO.save(disciplina);
	}
	
	@TransacionalCdi
	public Disciplina update(Disciplina disciplina) throws DacaServiceException {
		return this.disciplinaDAO.update(disciplina);
	}
	
	@TransacionalCdi
	public void delete(Disciplina disciplina) throws DacaServiceException {
		this.disciplinaDAO.delete(disciplina);
	}
	
	public Disciplina getByID(Long idDisciplina) throws DacaServiceException {
		return this.disciplinaDAO.getByID(idDisciplina);
				
	}
	
	public List<Disciplina> getAll() throws DacaServiceException {
		return this.disciplinaDAO.getAll();
	}
	
	public List<Disciplina> findUserByFirstName(String firstName) throws DacaServiceException {
		try {
			return this.disciplinaDAO.findUserByFirstName(firstName);
		} catch (DacaPersistenciaException e) {
			throw new DacaServiceException(e.getMessage(), e);
		}
	}
	
}
