package com.gacademico.beans;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedProperty;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.gacademico.entities.Aluno;
import com.gacademico.entities.Disciplina;
import com.gacademico.entities.Professor;
import com.gacademico.entities.User;
import com.gacademico.services.DacaServiceException;
import com.gacademico.services.DisciplinaService;
import com.gacademico.services.ProfessorService;
import com.gacademico.services.UserService;

@Named
@ViewScoped
public class Index extends AbstractBean {
	
	private static final long serialVersionUID = -4341438765228072955L;

	private List<User> users;
	
	private List<Professor> professores;
	private List<Aluno> alunos;
	
	@Inject
	@ManagedProperty("#{userService}")
	private UserService userService;
	
	@Inject
	private ProfessorService professorService;
	
	private String firstNameFiltro;
	
	
	public List<User> getUsers() {
		return users;
	}
	
	public List<Professor> getProfessores() {
		return professores;
	}
	
	
	
	public String getFirstNameFiltro() {
		return firstNameFiltro;
	}
	
	public void setFirstNameFiltro(String firstNameFiltro) {
		this.firstNameFiltro = firstNameFiltro;
	}
	
	@PostConstruct
	public void init() {
		filtrar();
	}
	
	public void filtrar() {
		try {
			users = userService.findUserByFirstName(firstNameFiltro);
		} catch (DacaServiceException e) {
			reportarMensagemDeErro(e.getMessage());
		}
	}

	public void limpar() {
		firstNameFiltro = null;
	}
	
}
