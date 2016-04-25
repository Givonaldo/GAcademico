package com.gacademico.beans;

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
	
	private Professor professor;
	
	@PostConstruct
	public void init(){
		professor = new Professor();
	}
	
	public String salvar(){
		professor.setGrupo(Grupo.PROFESSOR);
		try {
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
	
}
