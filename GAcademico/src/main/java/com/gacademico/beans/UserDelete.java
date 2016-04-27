package com.gacademico.beans;

import javax.enterprise.context.RequestScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import com.gacademico.entities.User;
import com.gacademico.services.DacaServiceException;
import com.gacademico.services.UserService;

@Named
@ViewScoped
public class UserDelete extends AbstractBean {
	
	private static final long serialVersionUID = 4804260264032468336L;

	private User user;

	@Inject @RequestScoped
	private UserService userService;

	public String delete() {
		try {
			userService.delete(user);
			reportarMensagemDeSucesso("Usuário removido com sucesso!");
		} catch (DacaServiceException e) {
			reportarMensagemDeErro(e.getMessage());
			return null;
		}
		return EnderecoPaginas.PAGINA_PRINCIPAL;
	}

	public String cancel() {
		return EnderecoPaginas.PAGINA_PRINCIPAL;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
