package com.gacademico.beans;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import com.gacademico.entities.Administrador;
import com.gacademico.entities.Grupo;
import com.gacademico.services.AdministradorService;
import com.gacademico.services.DacaServiceException;

@Named
@ViewScoped
public class CadastroDeAdministrador extends AbstractBean {

	private static final long serialVersionUID = -2253135919635351830L;
	
	@Inject
	private AdministradorService service;
	private Long idAdm;
	private Administrador adm;
	
	@PostConstruct
	public void init(){
		adm = new Administrador();
	}
	
	public String salvar(){
		adm.setGrupo(Grupo.ADMIN);
		try {
			service.criptografarSenha(adm);
			service.save(adm);
		} catch (DacaServiceException e) {
			e.printStackTrace();
		}
		
		return EnderecoPaginas.PAGINA_PRINCIPAL;
	}

	public String deletar(){
		try {
			service.delete(service.getByID(idAdm));
		} catch (DacaServiceException e) {
			e.printStackTrace();
		}
		return EnderecoPaginas.PAGINA_PRINCIPAL;
	}
	
	public Administrador getAdm() {
		return adm;
	}
	
	public void setAdm(Administrador adm) {
		this.adm = adm;
	}
	
}
