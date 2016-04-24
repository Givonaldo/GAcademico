package com.gacademico.beans;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.gacademico.entities.Disciplina;
import com.gacademico.services.DacaServiceException;
import com.gacademico.services.UserService;

@Named
@ViewScoped
public class CadastroDeDisciplinaBean extends AbstractBean {

	private static final long serialVersionUID = -4114792000125800037L;

	@Inject
	private UserService service;

	private Disciplina disciplina;

	@PostConstruct
	public void initDisciplina() {
		this.disciplina = new Disciplina();
	}

	public void salvarDisciplina() {
		try {
			service.save(this.disciplina);
		} catch (DacaServiceException e) {
			e.printStackTrace();
		}
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	
	public Disciplina getDisciplina() {
		return disciplina;
	}
	
}