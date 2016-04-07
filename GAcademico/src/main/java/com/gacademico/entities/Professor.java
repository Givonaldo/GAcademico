package com.gacademico.entities;

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
public class Professor {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="PROFESSOR_SEQUENCE")
	private Long idProfessor;
	
	@Column(name = "CL_NOMES")
	private String nome;
	
	@OneToMany
	private List<Disciplina> disciplinas;
	
}
