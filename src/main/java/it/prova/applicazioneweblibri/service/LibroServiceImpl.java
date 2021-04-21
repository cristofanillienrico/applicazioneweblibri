package it.prova.applicazioneweblibri.service;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.applicazioneweblibri.dao.LibroDAO;
import it.prova.applicazioneweblibri.model.Libro;
import it.prova.applicazioneweblibri.web.listner.LocalEntityManagerFactoryListener;

public class LibroServiceImpl implements LibroService {

	private LibroDAO libroDao;

	@Override
	public void setLibroDao(LibroDAO libroDao) {
		this.libroDao = libroDao;

	}

	@Override
	public List<Libro> listAll() throws Exception {
		// questo è come una connection
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			// uso l'injection per il dao
			libroDao.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return libroDao.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}
	}

	@Override
	public Libro caricaSingoloElemento(Long idInput) throws Exception {
		// questo è come una connection
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			// uso l'injection per il dao
			libroDao.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return libroDao.findOne(idInput);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}
	}

	@Override
	public void aggiorna(Libro input) throws Exception {
		// questo è come una connection
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			libroDao.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			libroDao.update(input);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}

	}

	@Override
	public void inserisciNuovo(Libro input) throws Exception {
		// questo è come una connection
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			libroDao.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			libroDao.insert(input);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}

	}

	@Override
	public void rimuovi(Libro input) throws Exception {
		// questo è come una connection
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			libroDao.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			libroDao.delete(input);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}

	}

	@Override
	public List<Libro> findByExample(Libro input) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
