package com.gacademico.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import com.gacademico.entities.Periodo;

/**
 * 
 * @author gilvonaldo
 *
 */
public class PeriodoDAO extends DAO {

	public void save(Periodo periodo) {
		
		EntityManager em = getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		try {
			em.persist(periodo);
			transaction.commit();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			transaction.rollback();
		} finally {
			em.close();
		}
	}

	public Periodo update(Periodo periodo) {
		EntityManager em = getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		Periodo resultado = periodo;
		try {
			resultado = em.merge(periodo);
			transaction.commit();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			transaction.rollback();
		} finally {
			em.close();
		}
		return resultado;
	}

	public void delete(Periodo periodo) {
		
		EntityManager em = getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		try {
			periodo = em.merge(periodo);
			em.remove(periodo);
			transaction.commit();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			transaction.rollback();
		} finally {
			em.close();
		}
	}

	public Periodo getByID(Long periodoId) {
		EntityManager em = getEntityManager();
		Periodo resultado = null;
		try {
			resultado = em.find(Periodo.class, periodoId);
		} catch (PersistenceException pe) {
			pe.printStackTrace();
		} finally {
			em.close();
		}

		return resultado;
	}

	public List<Periodo> getAll() {
		
		EntityManager em = getEntityManager();
		List<Periodo> resultado = null;
		try {
			TypedQuery<Periodo> query = em.createQuery("SELECT a FROM PERIODO a", Periodo.class);
			resultado = query.getResultList();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
		} finally {
			em.close();
		}
		return resultado;
	}

}
