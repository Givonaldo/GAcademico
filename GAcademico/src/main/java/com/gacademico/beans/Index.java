package com.gacademico.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import com.gacademico.entities.User;
import com.gacademico.services.DacaServiceException;
import com.gacademico.services.UserService;

@Named
@RequestScoped
public class Index extends AbstractBean {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4341438765228072955L;

	private List<User> users;

	@Inject
	private UserService userService;

	private String firstNameFiltro;
	
	public List<User> getUsers() {
		return users;
	}
	
	public String getFirstNameFiltro() {
		return firstNameFiltro;
	}
	
	public void setFirstNameFiltro(String firstNameFiltro) {
		this.firstNameFiltro = firstNameFiltro;
	}
	
	@PostConstruct
	public void init() {
		filtrar();
	}
	
	public void filtrar() {
		try {
			users = userService.findUserByFirstName(firstNameFiltro);
		} catch (DacaServiceException e) {
			reportarMensagemDeErro(e.getMessage());
		}
	}

	public void limpar() {
		firstNameFiltro = null;
	}
	
}
