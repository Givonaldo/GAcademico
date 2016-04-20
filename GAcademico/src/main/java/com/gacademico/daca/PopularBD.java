package com.gacademico.daca;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import com.gacademico.entities.Disciplina;
import com.gacademico.entities.Grupo;
import com.gacademico.entities.User;
import com.gacademico.services.DacaServiceException;
import com.gacademico.services.UserService;

public final class PopularBD {

	public static void main(String[] args) {

		EntityManagerFactory emf = null;
		EntityManager em = null;
		EntityTransaction tx = null;
		UserService userService = null;

		try {
			emf = Persistence.createEntityManagerFactory("GAcademico");
			em = emf.createEntityManager();
			userService = new UserService();

			tx = em.getTransaction();
			tx.begin();

			//getDisciplina();
			
			List<User> usuarios = new ArrayList<User>();

			usuarios.add(getUsuario());
			usuarios.add(getUsuarioAdmin());

			for (User user : usuarios) {
				userService.criptografarSenha(user);
				em.persist(user);
			}

			tx.commit();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		} catch (DacaServiceException e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
			if (emf != null) {
				emf.close();
			}
		}

	}	
	
	private static User getUsuarioAdmin() {
		User user = new User();

		user.setLogin("admin");
		user.setPassword("1234567");
		user.setGrupo(Grupo.ADMIN);

		user.setFirstName("Fulano");
		user.setLastName("Tal");
		user.setEmail("admin@ggmail.com");

		return user;
	}

	private static User getUsuario() {
		User user = new User();

		user.setLogin("visitante");
		user.setPassword("123456");
		user.setGrupo(Grupo.PROFESSOR);

		user.setFirstName("Sicrano");
		user.setLastName("Tal");
		user.setEmail("visitante@ggmail.com");

		return user;
	}
	
	@SuppressWarnings("unused")
	private static Disciplina getDisciplina() {
		Disciplina disciplina = new Disciplina();

		disciplina.setCargaHoraria(100);
		disciplina.setCodigo("DACA");
		disciplina.setNome("Desenvolvimento de Aplicações Corporativas Avançadas");

		return disciplina;
	}

}