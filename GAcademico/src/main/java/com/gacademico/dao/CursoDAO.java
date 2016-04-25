package com.gacademico.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import com.gacademico.entities.Curso;

public class CursoDAO extends DAO {

	public void save(Curso curso) {
		EntityManager em = getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		try {
			em.persist(curso);
			transaction.commit();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			transaction.rollback();
		} finally {
			em.close();
		}
	}

	public Curso update(Curso curso) {
		EntityManager em = getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		Curso resultado = curso;
		try {
			resultado = em.merge(curso);
			transaction.commit();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			transaction.rollback();
		} finally {
			em.close();
		}
		return resultado;
	}

	public void delete(Curso curso) {
		EntityManager em = getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		try {
			curso = em.merge(curso);
			em.remove(curso);
			transaction.commit();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			transaction.rollback();
		} finally {
			em.close();
		}
	}

	public Curso getByID(Long cursoId) {
		EntityManager em = getEntityManager();
		Curso resultado = null;
		try {
			resultado = em.find(Curso.class, cursoId);
		} catch (PersistenceException pe) {
			pe.printStackTrace();
		} finally {
			em.close();
		}

		return resultado;
	}

	public List<Curso> getAll() {
		EntityManager em = getEntityManager();
		List<Curso> resultado = null;
		try {
			TypedQuery<Curso> query = em.createQuery("SELECT a FROM CURSO a", Curso.class);
			resultado = query.getResultList();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
		} finally {
			em.close();
		}
		return resultado;
	}

	public List<Curso> findUserByFirstName(String nome) throws DacaPersistenciaException {
		EntityManager em = getEntityManager();
		List<Curso> resultado = null;
		if (nome == null) {
			nome = "";
		}
		try {
			TypedQuery<Curso> query = em.createQuery("select u from CURSO u where u.nome like :nome",
					Curso.class);
			query.setParameter("nome", "%" + nome + "%");
			resultado = query.getResultList();
		} catch (PersistenceException pe) {
			throw new DacaPersistenciaException("Ocorreu algum problema ao tentar recuperar os usuários com base no primeiro nome.", pe);
		}

		return resultado;
	}

	
}
