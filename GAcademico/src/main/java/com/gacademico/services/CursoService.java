package com.gacademico.services;

import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import com.gacademico.dao.CursoDAO;
import com.gacademico.entities.Curso;
import com.gacademico.util.TransacionalCdi;

public class CursoService implements Serializable {

	private static final long serialVersionUID = -6285684707578577338L;

	@Inject
	private CursoDAO cursoDAO;
	
	@TransacionalCdi
	public void save(Curso curso) throws DacaServiceException {
		this.cursoDAO.save(curso);
	}
	
	@TransacionalCdi
	public Curso update(Curso curso) throws DacaServiceException {
		return this.cursoDAO.update(curso);
	}
	
	@TransacionalCdi
	public void delete(Curso curso) throws DacaServiceException {
		this.cursoDAO.delete(curso);
	}
	
	public Curso getByID(Long idCurso) throws DacaServiceException {
		return this.cursoDAO.getByID(idCurso);
	}
	
	public List<Curso> getAll() throws DacaServiceException {
		return this.cursoDAO.getAll();
	}
	
}
