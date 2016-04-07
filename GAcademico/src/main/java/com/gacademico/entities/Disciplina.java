package com.gacademico.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 
 * @author gilvonaldo
 *
 */
@Entity
@Table(name = "TB_DISCIPLINAS")
@SequenceGenerator(name = "DISCIPLINA_SEQUENCE", sequenceName = "DISCIPLINA_SEQUENCE", allocationSize = 1, initialValue = 1)
public class Disciplina implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="DISCIPLINA_SEQUENCE")
	private Long idDisciplina;
	
	@ManyToOne
	private Professor professor;
	
	@Column(name = "CL_NOMES")
	private String nome;
	
	@Column(name = "CL_CARGAS_HORARIAS")
	private int cargaHoraria;
	
	@ManyToMany(mappedBy = "alunos", cascade = { CascadeType.PERSIST })
	private List<Aluno> alunos;
	
	public Long getIdDisciplina() {
		return idDisciplina;
	}
	
	public void setIdDisciplina(Long idDisciplina) {
		this.idDisciplina = idDisciplina;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getCargaHoraria() {
		return cargaHoraria;
	}
	
	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
	
	public List<Aluno> getAlunos() {
		return alunos;
	}
	
	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
	
	
}
