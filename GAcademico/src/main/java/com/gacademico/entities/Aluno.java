package com.gacademico.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 
 * @author gilvonaldo
 *
 */
@Entity(name = "ALUNO")
@Table(name = "TB_ALUNOS")
@SequenceGenerator(name = "ALUNO_SEQUENCE", sequenceName = "ALUNO_SEQUENCE", allocationSize = 1, initialValue = 1)
public class Aluno implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="ALUNO_SEQUENCE")
	private Long idAluno;
	
	@Column(name = "CL_NOMES")
	private String nome;
	
	@Column(name = "CL_MATRICULAS")
	private int matricula;
	
	@ManyToOne
	private Curso curso;
	
	@ManyToMany(cascade = { CascadeType.PERSIST })
	@JoinTable(name = "TB_ALUNOS_DISCIPLINAS", 
			   joinColumns = @JoinColumn(name = "DISCIPLINAS_FK"), 
			   inverseJoinColumns = @JoinColumn(name = "ALUNOS_FK"))
	private List<Disciplina> disciplinas;

	public Long getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(Long idAluno) {
		this.idAluno = idAluno;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

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
