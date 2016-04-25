package com.gacademico.beans;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import com.gacademico.entities.Disciplina;
import com.gacademico.entities.Professor;
import com.gacademico.services.DacaServiceException;
import com.gacademico.services.DisciplinaService;
import com.gacademico.services.ProfessorService;

@Named
@ViewScoped
public class CadastroDeDisciplinaBean extends AbstractBean {

	private static final long serialVersionUID = -4114792000125800037L;

	@Inject
	private DisciplinaService serviceDisciplina;
	
	private List<Professor> professores; 
	
	@Inject
	private ProfessorService serviceProfessor;

	private Professor professor;
	
	private Disciplina disciplina;

	@PostConstruct
	public void initDisciplina() {

		this.disciplina = new Disciplina();
		this.professor = new Professor();
		try {
			professores = serviceProfessor.getAll();
		} catch (DacaServiceException e) {
			e.printStackTrace();
		}
		
	}

	public String salvarDisciplina() {
		try {
			serviceDisciplina.save(this.disciplina);
		} catch (DacaServiceException e) {
			e.printStackTrace();
		}
		return EnderecoPaginas.PAGINA_PRINCIPAL;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	
	public Disciplina getDisciplina() {
		return disciplina;
	}

	public List<Professor> getProfessores() {
		return professores;
	}
	
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	
	public Professor getProfessor() {
		return professor;
	}
	
}