package com.gacademico.entities;

import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * @author gilvonaldo
 *
 */
@Entity
@Table(name = "TB_PROFESSORES")
@DiscriminatorValue("2")
public class Professor extends User {

	private static final long serialVersionUID = 8632718143223729934L;
	
	@OneToMany
	private List<Disciplina> disciplinas;

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
