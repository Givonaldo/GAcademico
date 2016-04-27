package com.gacademico.beans;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import com.gacademico.entities.Aluno;
import com.gacademico.entities.Curso;
import com.gacademico.entities.Grupo;
import com.gacademico.services.AlunoService;
import com.gacademico.services.CursoService;
import com.gacademico.services.DacaServiceException;

@Named
@ViewScoped
public class CadastroDeAlunoBean extends AbstractBean {

	private static final long serialVersionUID = -773966293450979419L;
	
	@Inject
	private AlunoService service;
	private List<Aluno> alunos;
	private List<Curso> cursos;
	
	private Aluno aluno;
	
	@Inject
	private CursoService cursoService;
	
	@PostConstruct
	public void userInit(){
		aluno = new Aluno();
		try {
			alunos = service.getAll();
			cursos = cursoService.getAll();
		} catch (DacaServiceException e) {
			e.printStackTrace();
		}
	}
	
	public String salvar(){
		aluno.setGrupo(Grupo.ALUNO);
		try {
			service.criptografarSenha(aluno);
			service.save(aluno);
		} catch (DacaServiceException e) {
			e.printStackTrace();
		}
		return EnderecoPaginas.PAGINA_PRINCIPAL;
	}

	
	
	public Aluno getAluno() {
		return aluno;
	}
	
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public List<Curso> getCursos() {
		return cursos;
	}
	
	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}
	
	public CursoService getCursoService() {
		return cursoService;
	}
	
	public void setCursoService(CursoService cursoService) {
		this.cursoService = cursoService;
	}
	
	public List<Aluno> getAlunos() {
		return alunos;
	}
	
	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
	
}