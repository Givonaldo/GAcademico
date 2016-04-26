package com.gacademico.entities;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.inject.Inject;
import javax.inject.Named;
import com.gacademico.services.DacaServiceException;
import com.gacademico.services.UserService;

@Named
@RequestScoped
public class UserConverter implements Converter {

	@Inject
	private UserService users;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
            if (value == null || value.trim().isEmpty()) {
                    return null;
            }
            int id = Integer.parseInt(value);
            
            try {
				return users.getByID(id);
			} catch (DacaServiceException e) {
				String msgErroStr = String.format(
						"Erro de conversão! Não foi possível realizar a conversão da string '%s' para o tipo esperado.",
						value);
				FacesMessage msgErro = new FacesMessage(FacesMessage.SEVERITY_ERROR, msgErroStr, msgErroStr);
				throw new ConverterException(msgErro);
			}
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
            if (value == null) {
                    return null;
            }
            Integer id = ((User) value).getId();
            
            return (id != null) ? id.toString() : null;
    }	
	
}

