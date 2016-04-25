package com.gacademico.services;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import javax.inject.Inject;

import com.gacademico.dao.DacaPersistenciaException;
import com.gacademico.dao.UserDAO;
import com.gacademico.entities.User;
import com.gacademico.util.TransacionalCdi;

public class UserService implements Serializable {

	private static final long serialVersionUID = -8086449267296650848L;
	
	@Inject
	private UserDAO userDAO;
	
	@TransacionalCdi
	public void save(User user) throws DacaServiceException {
		try {
			this.userDAO.save(user);
		} catch (DacaPersistenciaException e) {
			throw new DacaServiceException(e.getMessage(), e);
		}
	}
	
	@TransacionalCdi
	public User update(User user) throws DacaServiceException {
		try {
			return this.userDAO.update(user);
		} catch (DacaPersistenciaException e) {
			throw new DacaServiceException(e.getMessage(), e);
		}
	}
	
	@TransacionalCdi
	public void delete(User user) throws DacaServiceException {
		try {
			this.userDAO.delete(user);
		} catch (DacaPersistenciaException e) {
			throw new DacaServiceException(e.getMessage(), e);
		}
	}
	
	public User getByID(int userId) throws DacaServiceException {
		try {
			return this.userDAO.getByID(userId);
		} catch (DacaPersistenciaException e) {
			throw new DacaServiceException(e.getMessage(), e);
		}
	}
	
	public List<User> getAll() throws DacaServiceException {
		try {
			return this.userDAO.getAll();
		} catch (DacaPersistenciaException e) {
			throw new DacaServiceException(e.getMessage(), e);
		}
	}
	
	public List<User> findUserByFirstName(String firstName) throws DacaServiceException {
		try {
			return this.userDAO.findUserByFirstName(firstName);
		} catch (DacaPersistenciaException e) {
			throw new DacaServiceException(e.getMessage(), e);
		}
	}

	public void criptografarSenha(User user) throws DacaServiceException {
		user.setPassword(criptografarSenha(user.getPassword()));
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
