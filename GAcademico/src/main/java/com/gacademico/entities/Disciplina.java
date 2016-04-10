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
@Entity(name = "DICIPLINA")
@Table(name = "TB_DISCIPLINAS")
@SequenceGenerator(name = "DISCIPLINA_SEQUENCE", sequenceName = "DISCIPLINA_SEQUENCE", allocationSize = 1, initialValue = 1)
public class Disciplina implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="DISCIPLINA_SEQUENCE")
	private Long idDisciplina;
	
	@Column(name = "CL_CODIGOS")
	private String codigo;
	
	@ManyToOne
	private Professor professor;
	
	@Column(name = "CL_NOMES")
	private String nome;
	
	@Column(name = "CL_CARGAS_HORARIAS")
	private int cargaHoraria;
	
	@ManyToMany(mappedBy = "alunos", cascade = { CascadeType.PERSIST })
	private List<Aluno> alunos;
	
	@Column(name = "CL_NUMEROS_DE_AULAS_PREVISTA")
	private int numeroAulasPrevisto;
	
	@Column(name = "CL_NUMEROS_DE_AULAS_MINISTRADAS")
	private int numeroAulasMinistradas;
	 
	@Column(name = "CL_PERCENTUAL_DE_FREQUENCIA_OBRIGATORIAS")
	private String percentFrequenciaObrig;
	 
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

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public int getNumeroAulasPrevisto() {
		return numeroAulasPrevisto;
	}

	public void setNumeroAulasPrevisto(int numeroAulasPrevisto) {
		this.numeroAulasPrevisto = numeroAulasPrevisto;
	}

	public int getNumeroAulasMinistradas() {
		return numeroAulasMinistradas;
	}

	public void setNumeroAulasMinistradas(int numeroAulasMinistradas) {
		this.numeroAulasMinistradas = numeroAulasMinistradas;
	}

	public String getPercentFrequenciaObrig() {
		return percentFrequenciaObrig;
	}

	public void setPercentFrequenciaObrig(String percentFrequenciaObrig) {
		this.percentFrequenciaObrig = percentFrequenciaObrig;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
