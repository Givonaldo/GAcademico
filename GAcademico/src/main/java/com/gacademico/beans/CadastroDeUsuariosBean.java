package com.gacademico.beans;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import com.gacademico.entities.Grupo;
import com.gacademico.entities.User;
import com.gacademico.services.DacaServiceException;
import com.gacademico.services.UserService;

@Named
@ViewScoped
public class CadastroDeUsuariosBean extends AbstractBean {

	private static final long serialVersionUID = -773966293450979419L;

	private String opcao;
	private String primeiroNome;
	private String segundoNome;
	private String email;
	private String grupo;
	private String login;
	private String senha;
	
	@Inject
	private UserService service;
	
	private User usuario;
	
	@PostConstruct
	public void userInit(){
		usuario = new User();
	}
	
	public void salvarUsuario(){
				 
		usuario.setFirstName(primeiroNome);
		usuario.setEmail(email);
		usuario.setLastName(segundoNome);
		usuario.setEmail(email);
		usuario.setLogin(login);
		usuario.setPassword(senha);
		if (grupo == ("Administrador")){
			usuario.setGrupo(Grupo.ADMIN);
		}else if (grupo == ("Professor")){
			usuario.setGrupo(Grupo.PROFESSOR);
		}else if (grupo == ("Aluno")){
			usuario.setGrupo(Grupo.ALUNO);
		}
		try {
			service.save(usuario);
		} catch (DacaServiceException e) {
			e.printStackTrace();
		}
	}
	
	public User getUsuario() {
		return usuario;
	}
	
	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}
	
	public String getOpcao() {
		return opcao;
	}
	
	public void setOpcao(String opcao) {
		this.opcao = opcao;
	}

	public String getPrimeiroNome() {
		return primeiroNome;
	}

	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}

	public String getSegundoNome() {
		return segundoNome;
	}

	public void setSegundoNome(String segundoNome) {
		this.segundoNome = segundoNome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public UserService getService() {
		return service;
	}

	public void setService(UserService service) {
		this.service = service;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}