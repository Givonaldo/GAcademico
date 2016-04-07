package com.gacademico.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * 
 * @author gilvonaldo
 *
 */
public abstract class DAO {

	static EntityManagerFactory emf;
	
	static {
		emf = Persistence.createEntityManagerFactory("GAcademico");
	}
	
	protected EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
	
	public void close() {
		emf.close();
	}
}
