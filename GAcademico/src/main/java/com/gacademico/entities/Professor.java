package com.gacademico.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 
 * @author gilvonaldo
 *
 */
@Entity
@Table(name = "TB_PROFESSORES")
@SequenceGenerator(name = "PROFESSOR_SEQUENCE", sequenceName = "PROFESSOR_SEQUENCE", allocationSize = 1, initialValue = 1)
public class Professor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="PROFESSOR_SEQUENCE")
	private Long idProfessor;
	
	@Column(name = "CL_NOMES")
	private String nome;
	
	@OneToMany
	private List<Disciplina> disciplinas;

	public Long getIdProfessor() {
		return idProfessor;
	}

	public void setIdProfessor(Long idProfessor) {
		this.idProfessor = idProfessor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
