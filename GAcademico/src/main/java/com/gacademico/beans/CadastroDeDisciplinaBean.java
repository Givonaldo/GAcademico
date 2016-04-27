package com.gacademico.beans;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.DualListModel;

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
	private List<Disciplina> disciplinasCadastradas;
	private List<String> disciplinas;
	private List<String> listaDeDisciplinasSelecionadas;
	private DualListModel<String> listaDeDisciplinas;
	
	@Inject
	private ProfessorService serviceProfessor;

	private Professor professor;
	
	private Disciplina disciplina;

	@PostConstruct
	public void initDisciplina() {

		this.disciplina = new Disciplina();
		this.professor = new Professor();
		listaDeDisciplinasSelecionadas = new ArrayList<>();
		disciplinas = new ArrayList<>();
		try {
			disciplinasCadastradas = serviceDisciplina.getAll();
			for(Disciplina d : serviceDisciplina.getAll()){
				disciplinas.add(d.getNome());
			}
			listaDeDisciplinas = new DualListModel<String>(disciplinas, listaDeDisciplinasSelecionadas);
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

	
	public List<String> getDisciplinas() {
		return disciplinas;
	}
	
	public void setDisciplinas(List<String> disciplinas) {
		this.disciplinas = disciplinas;
	}
	
	public DualListModel<String> getListaDeDisciplinas() {
		return listaDeDisciplinas;
	}
	
	public void setListaDeDisciplinas(DualListModel<String> listaDeDisciplinas) {
		this.listaDeDisciplinas = listaDeDisciplinas;
	}
	
	public List<String> getListaDeDisciplinasSelecionadas() {
		return listaDeDisciplinasSelecionadas;
	}
	
	public void setListaDeDisciplinasSelecionadas(List<String> listaDeDisciplinasSelecionadas) {
		this.listaDeDisciplinasSelecionadas = listaDeDisciplinasSelecionadas;
	}
	
	public DisciplinaService getServiceDisciplina() {
		return serviceDisciplina;
	}
	
	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
	}
	
	public ProfessorService getServiceProfessor() {
		return serviceProfessor;
	}
	
	public List<Disciplina> getDisciplinasCadastradas() {
		return disciplinasCadastradas;
	}
	
	public void setDisciplinasCadastradas(List<Disciplina> disciplinasCadastradas) {
		this.disciplinasCadastradas = disciplinasCadastradas;
	}
	
}