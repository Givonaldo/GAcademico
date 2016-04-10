package com.gacademico.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 
 * @author gilvonaldo
 *
 */
@Entity(name = "CURSO")
@Table(name = "TB_CURSOS")
@SequenceGenerator(name = "CURSO_SEQUENCE", sequenceName = "CURSO_SEQUENCE", allocationSize = 1, initialValue = 1)
public class Curso {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="CURSO_SEQUENCE")
	private Long idCurso;
	
	@Column(name = "CL_NOMES_DOS_CURSOS")
	private String nomeDoCurso;

	public Long getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(Long idCurso) {
		this.idCurso = idCurso;
	}

	public String getNomeDoCurso() {
		return nomeDoCurso;
	}

	public void setNomeDoCurso(String nomeDoCurso) {
		this.nomeDoCurso = nomeDoCurso;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
}
