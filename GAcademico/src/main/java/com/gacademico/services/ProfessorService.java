package com.gacademico.services;

import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import com.gacademico.dao.ProfessorDAO;
import com.gacademico.entities.Professor;
import com.gacademico.util.TransacionalCdi;

public class ProfessorService implements Serializable {

	private static final long serialVersionUID = -6264382101644260141L;
	
	@Inject
	private ProfessorDAO professorDAO;
	
	@TransacionalCdi
	public void save(Professor professor) throws DacaServiceException {
		this.professorDAO.save(professor);
	}
	
	@TransacionalCdi
	public Professor update(Professor professor) throws DacaServiceException {
		return this.professorDAO.update(professor);
	}
	
	@TransacionalCdi
	public void delete(Professor professor) throws DacaServiceException {
		this.professorDAO.delete(professor);
	}
	
	public Professor getByID(Long idProfessor) throws DacaServiceException {
		return this.professorDAO.getByID(idProfessor);
	}
	
	public List<Professor> getAll() throws DacaServiceException {
		return this.professorDAO.getAll();
	}
	
}
