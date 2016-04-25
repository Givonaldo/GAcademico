package com.gacademico.services;

import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import com.gacademico.dao.AlunoDAO;
import com.gacademico.entities.Aluno;
import com.gacademico.util.TransacionalCdi;

public class AlunoService implements Serializable {

	private static final long serialVersionUID = -9013432976653510661L;
	
	@Inject
	private AlunoDAO alunoDAO;
	
	@TransacionalCdi
	public void save(Aluno aluno) throws DacaServiceException {
		this.alunoDAO.save(aluno);
	}
	
	@TransacionalCdi
	public Aluno update(Aluno aluno) throws DacaServiceException {
		return this.alunoDAO.update(aluno);
	}
	
	@TransacionalCdi
	public void delete(Aluno aluno) throws DacaServiceException {
		this.alunoDAO.delete(aluno);
	}
	
	public Aluno getByID(Long idAluno) throws DacaServiceException {
		return this.alunoDAO.getByID(idAluno);
	}
	
	public List<Aluno> getAll() throws DacaServiceException {
		return this.alunoDAO.getAll();
	}
	
}