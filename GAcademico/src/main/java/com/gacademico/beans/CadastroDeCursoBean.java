package com.gacademico.beans;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import com.gacademico.entities.Curso;
import com.gacademico.services.CursoService;
import com.gacademico.services.DacaServiceException;

@Named
@ViewScoped
public class CadastroDeCursoBean extends AbstractBean {

	private static final long serialVersionUID = -9039517714343097561L;

	@Inject
	private CursoService service;
	
	private Curso curso;
	
	public void init(){
		curso = new Curso();
	}
	
	public String salvar(){
		try {
			service.save(curso);
		} catch (DacaServiceException e) {
			e.printStackTrace();
		}
		return EnderecoPaginas.PAGINA_PRINCIPAL;
	}
	
	public Curso getCurso() {
		return curso;
	}
	
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
}
