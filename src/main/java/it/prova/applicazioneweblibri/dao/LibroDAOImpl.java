package it.prova.applicazioneweblibri.dao;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.applicazioneweblibri.model.Libro;

public class LibroDAOImpl implements LibroDAO {

	private EntityManager entityManager;

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;

	}

	@Override
	public List<Libro> list() throws Exception {
		return entityManager.createQuery("from Libro", Libro.class).getResultList();
	}

	@Override
	public Libro findOne(Long id) throws Exception {
		return entityManager.find(Libro.class, id);

	}

	@Override
	public void update(Libro input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		input = entityManager.merge(input);

	}

	@Override
	public void insert(Libro input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.persist(input);

	}

	@Override
	public void delete(Libro input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.remove(entityManager.merge(input));

	}

}
