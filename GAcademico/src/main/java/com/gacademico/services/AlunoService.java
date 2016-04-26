package com.gacademico.services;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import javax.inject.Inject;
import com.gacademico.dao.AlunoDAO;
import com.gacademico.entities.Aluno;
import com.gacademico.util.TransacionalCdi;

public class AlunoService implements Serializable {

	private static final long serialVersionUID = -9013432976653510661L;
	
	@Inject
	private AlunoDAO alunoDAO;
	
	@TransacionalCdi
	public void save(Aluno aluno) throws DacaServiceException {
		this.alunoDAO.save(aluno);
	}
	
	@TransacionalCdi
	public Aluno update(Aluno aluno) throws DacaServiceException {
		return this.alunoDAO.update(aluno);
	}
	
	@TransacionalCdi
	public void delete(Aluno aluno) throws DacaServiceException {
		this.alunoDAO.delete(aluno);
	}
	
	public Aluno getByID(Long idAluno) throws DacaServiceException {
		return this.alunoDAO.getByID(idAluno);
	}
	
	public List<Aluno> getAll() throws DacaServiceException {
		return this.alunoDAO.getAll();
	}


	public void criptografarSenha(Aluno aluno) throws DacaServiceException {
		aluno.setPassword(criptografarSenha(aluno.getPassword()));
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