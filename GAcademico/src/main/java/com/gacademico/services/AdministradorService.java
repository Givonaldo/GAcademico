package com.gacademico.services;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import javax.inject.Inject;
import com.gacademico.dao.AdministradorDAO;
import com.gacademico.entities.Administrador;
import com.gacademico.util.TransacionalCdi;

public class AdministradorService implements Serializable {
	
	private static final long serialVersionUID = 1516706606233354659L;
	
	@Inject
	private AdministradorDAO administradorDAO;
	
	@TransacionalCdi
	public void save(Administrador adm) throws DacaServiceException {
		this.administradorDAO.save(adm);
	}
	
	@TransacionalCdi
	public Administrador update(Administrador adm) throws DacaServiceException {
		return this.administradorDAO.update(adm);
	}
	
	@TransacionalCdi
	public void delete(Administrador adm) throws DacaServiceException {
		this.administradorDAO.delete(adm);
	}
	
	public Administrador getByID(Long idAdm) throws DacaServiceException {
		return this.administradorDAO.getByID(idAdm);
	}
	
	public List<Administrador> getAll() throws DacaServiceException {
		return this.administradorDAO.getAll();
	}

	public void criptografarSenha(Administrador adm) throws DacaServiceException {
		adm.setPassword(criptografarSenha(adm.getPassword()));
	}

	/**
	 * Método que criptografa uma dada senha usando o método hash SHA-256.
	 * 
	 * @param password
	 *            senha a ser criptografada
	 * @return senha criptografada
	 * @throws DacaServiceException
	 *             lançada caso ocorra algum erro durante o processo
	 */
	private static String criptografarSenha(String password) throws DacaServiceException {
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-256");
			md.update(password.getBytes("UTF-8"));
			byte[] digest = md.digest();
			BigInteger bigInt = new BigInteger(1, digest);
			String output = bigInt.toString(16);
			return output;
		} catch (NoSuchAlgorithmException e) {
			throw new DacaServiceException("Não foi possível criptografar a senha!");
		} catch (UnsupportedEncodingException e) {
			throw new DacaServiceException("Não foi possível criptografar a senha!");
		}
	}	

	
}
