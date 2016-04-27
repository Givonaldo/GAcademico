package com.gacademico.beans;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import com.gacademico.entities.Periodo;
import com.gacademico.services.DacaServiceException;
import com.gacademico.services.PeriodoService;

@Named
@ViewScoped
public class CadastroDePeriodoBean extends AbstractBean {

	private static final long serialVersionUID = 916786130479835654L;

	@Inject
	private PeriodoService service;
	
	private Periodo periodo;
	
	@PostConstruct
	public void init(){
		periodo = new Periodo();
	}
	
	public String salvar(){
		try {
			service.save(periodo);
			reportarMensagemDeSucesso("Período Salvo com sucesso!");
		} catch (DacaServiceException e) {
			e.printStackTrace();
		}
		return EnderecoPaginas.PAGINA_PRINCIPAL;
	}
	
	public Periodo getPeriodo() {
		return periodo;
	}
	
	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}
	
	
}
