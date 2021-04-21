package it.prova.applicazioneweblibri.service;

import it.prova.applicazioneweblibri.dao.LibroDAO;
import it.prova.applicazioneweblibri.dao.LibroDAOImpl;

public class MyServiceFactory {

	// implementiamo il singleton in modo da evitare
	// proliferazione di riferimenti
	private static LibroService LIBRO_SERVICE_INSTANCE = null;
	private static LibroDAO LIBRODAO_INSTANCE = null;

	public static LibroService getLibroServiceInstance() {
		if (LIBRO_SERVICE_INSTANCE == null)
			LIBRO_SERVICE_INSTANCE = new LibroServiceImpl();

		if (LIBRODAO_INSTANCE == null)
			LIBRODAO_INSTANCE = new LibroDAOImpl();

		LIBRO_SERVICE_INSTANCE.setLibroDao(LIBRODAO_INSTANCE);

		return LIBRO_SERVICE_INSTANCE;
	}

}
