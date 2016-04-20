package com.gacademico.entities;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * @author gilvonaldo
 *
 */
@Entity(name = "ALUNO")
@Table(name = "TB_ALUNOS")
@DiscriminatorValue("3")
public class Aluno extends User {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "CL_MATRICULAS")
	private int matricula;
	
	@ManyToOne
	private Curso curso;
	
	@ManyToMany(cascade = { CascadeType.PERSIST })
	@JoinTable(name = "TB_ALUNOS_DISCIPLINAS", 
			   joinColumns = @JoinColumn(name = "DISCIPLINAS_FK"), 
			   inverseJoinColumns = @JoinColumn(name = "ALUNOS_FK"))
	private List<Disciplina> disciplinas;
	
	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
}
