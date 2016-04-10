package com.gacademico.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import com.gacademico.entities.Administrador;

/**
 * 
 * @author gilvonaldo
 *
 */
public class AdministradorDAO extends DAO {

	public void save(Administrador administrador) {
		EntityManager em = getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		try {
			em.persist(administrador);
			transaction.commit();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			transaction.rollback();
		} finally {
			em.close();
		}
	}

	public Administrador update(Administrador administrador) {
		EntityManager em = getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		Administrador resultado = administrador;
		try {
			resultado = em.merge(administrador);
			transaction.commit();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			transaction.rollback();
		} finally {
			em.close();
		}
		return resultado;
	}

	public void delete(Administrador administrador) {
		EntityManager em = getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		try {
			administrador = em.merge(administrador);
			em.remove(administrador);
			transaction.commit();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			transaction.rollback();
		} finally {
			em.close();
		}
	}

	public Administrador getByID(Long administradorId) {
		EntityManager em = getEntityManager();
		Administrador resultado = null;
		try {
			resultado = em.find(Administrador.class, administradorId);
		} catch (PersistenceException pe) {
			pe.printStackTrace();
		} finally {
			em.close();
		}

		return resultado;
	}

	public List<Administrador> getAll() {
		EntityManager em = getEntityManager();
		List<Administrador> resultado = null;
		try {
			TypedQuery<Administrador> query = em.createQuery("SELECT a FROM ADMINISTRADOR a", Administrador.class);
			resultado = query.getResultList();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
		} finally {
			em.close();
		}
		return resultado;
	}
	
}
