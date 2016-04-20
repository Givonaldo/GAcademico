package com.gacademico.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 
 * @author gilvonaldo
 *
 */
@Entity(name = "ADMINISTRADOR")
@Table(name = "TB_ADMINISTRADORES")
@DiscriminatorValue("1")
public class Administrador extends User {

	private static final long serialVersionUID = -6252787393819732009L;

	@Column(name = "CL_NOMES")
	private String nome;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
}
