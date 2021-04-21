package it.prova.applicazioneweblibri.dao;

public class MyDaoFactory {

	private static LibroDAO libroDaoInstance = null;

	public static LibroDAO getLibroDAOInstance() {
		if (libroDaoInstance == null)
			libroDaoInstance = new LibroDAOImpl();

		return libroDaoInstance;
	}

}
