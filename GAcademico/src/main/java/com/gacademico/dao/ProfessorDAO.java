package com.gacademico.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import com.gacademico.entities.Professor;

/**
 * 
 * @author gilvonaldo
 *
 */
public class ProfessorDAO extends DAO {

	public void save(Professor professor) {
		
		EntityManager em = getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		try {
			em.persist(professor);
			transaction.commit();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			transaction.rollback();
		} finally {
			em.close();
		}
	}

	public Professor update(Professor professor) {
		EntityManager em = getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		Professor resultado = professor;
		try {
			resultado = em.merge(professor);
			transaction.commit();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			transaction.rollback();
		} finally {
			em.close();
		}
		return resultado;
	}

	public void delete(Professor prefessor) {
		
		EntityManager em = getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		try {
			prefessor = em.merge(prefessor);
			em.remove(prefessor);
			transaction.commit();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			transaction.rollback();
		} finally {
			em.close();
		}
	}

	public Professor getByID(Long professorId) {
		EntityManager em = getEntityManager();
		Professor resultado = null;
		try {
			resultado = em.find(Professor.class, professorId);
		} catch (PersistenceException pe) {
			pe.printStackTrace();
		} finally {
			em.close();
		}

		return resultado;
	}

	public List<Professor> getAll() {
		
		EntityManager em = getEntityManager();
		List<Professor> resultado = null;
		try {
			TypedQuery<Professor> query = em.createQuery("SELECT a FROM PROFESSOR a", Professor.class);
			resultado = query.getResultList();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
		} finally {
			em.close();
		}
		return resultado;
	}

	
}
