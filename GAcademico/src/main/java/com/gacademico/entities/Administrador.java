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
@Entity(name = "ADMINISTRADOR")
@Table(name = "TB_ADMINISTRADORES")
@SequenceGenerator(name = "ADMINISTRADOR_SEQUENCE", sequenceName = "ADMINISTRADOR_SEQUENCE", allocationSize = 1, initialValue = 1)
public class Administrador {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="ADMINISTRADOR_SEQUENCE")
	private Long idAdministrador;
	
	@Column(name = "CL_NOMES")
	private String nome;

	public Long getIdAdministrador() {
		return idAdministrador;
	}

	public void setIdAdministrador(Long idAdministrador) {
		this.idAdministrador = idAdministrador;
	}

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
