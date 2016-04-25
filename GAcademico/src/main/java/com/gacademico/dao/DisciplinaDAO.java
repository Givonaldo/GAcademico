package com.gacademico.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import com.gacademico.entities.Disciplina;

/**
 * 
 * @author gilvonaldo
 *
 */
public class DisciplinaDAO extends DAO {
	
	public void save(Disciplina disciplina) {
		EntityManager em = getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		try {
			em.persist(disciplina);
			transaction.commit();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			transaction.rollback();
		} finally {
			em.close();
		}
	}

	public Disciplina update(Disciplina disciplina) {
		EntityManager em = getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		Disciplina resultado = disciplina;
		try {
			resultado = em.merge(disciplina);
			transaction.commit();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			transaction.rollback();
		} finally {
			em.close();
		}
		return resultado;
	}

	public void delete(Disciplina disciplina) {
		EntityManager em = getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		try {
			disciplina = em.merge(disciplina);
			em.remove(disciplina);
			transaction.commit();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			transaction.rollback();
		} finally {
			em.close();
		}
	}

	public Disciplina getByID(Long disciplinaId) {
		EntityManager em = getEntityManager();
		Disciplina resultado = null;
		try {
			resultado = em.find(Disciplina.class, disciplinaId);
		} catch (PersistenceException pe) {
			pe.printStackTrace();
		} finally {
			em.close();
		}

		return resultado;
	}

	public List<Disciplina> getAll() {
		EntityManager em = getEntityManager();
		List<Disciplina> resultado = null;
		try {
			TypedQuery<Disciplina> query = em.createQuery("SELECT a FROM DISCIPLINA a", Disciplina.class);
			resultado = query.getResultList();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
		} finally {
			em.close();
		}
		return resultado;
	}

	public List<Disciplina> findUserByFirstName(String nome) throws DacaPersistenciaException {
		EntityManager em = getEntityManager();
		List<Disciplina> resultado = null;
		if (nome == null) {
			nome = "";
		}
		try {
			TypedQuery<Disciplina> query = em.createQuery("select u from Disciplina u where u.nome like :nome",
					Disciplina.class);
			query.setParameter("nome", "%" + nome + "%");
			resultado = query.getResultList();
		} catch (PersistenceException pe) {
			throw new DacaPersistenciaException("Ocorreu algum problema ao tentar recuperar os usuários com base no primeiro nome.", pe);
		}

		return resultado;
	}
	
}
