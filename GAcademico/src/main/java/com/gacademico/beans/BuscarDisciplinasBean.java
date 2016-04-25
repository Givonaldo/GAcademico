package com.gacademico.beans;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import com.gacademico.entities.Disciplina;
import com.gacademico.services.DacaServiceException;
import com.gacademico.services.DisciplinaService;

@Named
@RequestScoped
public class BuscarDisciplinasBean extends AbstractBean {

	private static final long serialVersionUID = 189144881821704268L;

	private List<Disciplina> disciplinas;
	
	private String firstNameFiltro;
	
	@Inject
	private DisciplinaService disciplinaService;
	
	public List<Disciplina> getDisciplina() {
		return disciplinas;
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
			disciplinas = disciplinaService.findUserByFirstName(firstNameFiltro);
		} catch (DacaServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void limpar() {
		firstNameFiltro = null;
	}

	
}
