package com.gacademico.services;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import javax.inject.Inject;
import com.gacademico.dao.ProfessorDAO;
import com.gacademico.entities.Professor;
import com.gacademico.util.TransacionalCdi;

public class ProfessorService implements Serializable {

	private static final long serialVersionUID = -6264382101644260141L;
	
	@Inject
	private ProfessorDAO professorDAO;
	
	@TransacionalCdi
	public void save(Professor professor) throws DacaServiceException {
		this.professorDAO.save(professor);
	}
	
	@TransacionalCdi
	public Professor update(Professor professor) throws DacaServiceException {
		return this.professorDAO.update(professor);
	}
	
	@TransacionalCdi
	public void delete(Professor professor) throws DacaServiceException {
		this.professorDAO.delete(professor);
	}
	
	public Professor getByID(Long idProfessor) throws DacaServiceException {
		return this.professorDAO.getByID(idProfessor);
	}
	
	public List<Professor> getAll() throws DacaServiceException {
		return this.professorDAO.getAll();
	}

	public void criptografarSenha(Professor professor) throws DacaServiceException {
		professor.setPassword(criptografarSenha(professor.getPassword()));
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
