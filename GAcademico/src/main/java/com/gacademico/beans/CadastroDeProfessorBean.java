package com.gacademico.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import com.gacademico.entities.Grupo;
import com.gacademico.entities.Professor;
import com.gacademico.services.DacaServiceException;
import com.gacademico.services.ProfessorService;

@Named
@ViewScoped
public class CadastroDeProfessorBean extends AbstractBean {

	private static final long serialVersionUID = -866048718174398637L;

	@Inject
	private ProfessorService professorService;
	
	private List<Professor> professores;
	
	private Professor professor;
	
	@PostConstruct
	public void init(){
		professor = new Professor();
		try {
			professores = professorService.getAll();
		} catch (DacaServiceException e) {
			e.printStackTrace();
		}
	}
	
	public String salvar(){
		professor.setGrupo(Grupo.PROFESSOR);
		try {
			professorService.criptografarSenha(professor);
			professorService.save(professor);
		} catch (DacaServiceException e) {
			e.printStackTrace();
		}
		return EnderecoPaginas.PAGINA_PRINCIPAL;
	}
	
	public Professor getProfessor() {
		return professor;
	}
	
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	
	public List<Professor> getProfessores() {
		return professores;
	}
	
	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
	}
	
}
