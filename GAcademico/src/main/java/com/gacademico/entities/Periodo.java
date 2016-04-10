package com.gacademico.entities;

import java.io.Serializable;
import java.util.Date;
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
@Entity(name = "PERIODO")
@Table(name = "TB_PERIODOS")
@SequenceGenerator(name = "PERIODO_SEQUENCE", sequenceName = "PERIODO_SEQUENCE", allocationSize = 1, initialValue = 1)
public class Periodo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="DISCIPLINA_SEQUENCE")
	private Long idPeriodo;
	
	@Column(name = "CL_NOMES")
	private String nome;
	
	@Column(name = "CL_DATAS_DE_INICIOS")
	private Date dataDeInicio;
	
	@Column(name = "CL_DATAS_DE_TERMINOS")
	private Date dataDeTermino;
	
	public Long getIdPeriodo() {
		return idPeriodo;
	}
	
	public void setIdPeriodo(Long idPeriodo) {
		this.idPeriodo = idPeriodo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Date getDataDeInicio() {
		return dataDeInicio;
	}
	
	public void setDataDeInicio(Date dataDeInicio) {
		this.dataDeInicio = dataDeInicio;
	}
	
	public Date getDataDeTermino() {
		return dataDeTermino;
	}
	
	public void setDataDeTermino(Date dataDeTermino) {
		this.dataDeTermino = dataDeTermino;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
}
