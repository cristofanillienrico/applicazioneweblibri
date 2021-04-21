package it.prova.applicazioneweblibri.web.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.applicazioneweblibri.model.Libro;
import it.prova.applicazioneweblibri.service.LibroService;
import it.prova.applicazioneweblibri.service.MyServiceFactory;
import it.prova.applicazioneweblibri.utility.UtilityArticoloForm;

@WebServlet("/ExecuteModificaLibroServlet")
public class ExecuteModificaLibroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ExecuteModificaLibroServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// estraggo input
		String titoloInputParam = request.getParameter("titolo");
		String genereInputParam = request.getParameter("genere");
		String pagineInputStringParam = request.getParameter("pagine");
		String dataPubblicazioneStringParam = request.getParameter("dataPubblicazione");

		String idLibroParam = request.getParameter("idLibro");

		LibroService serviceLibro = MyServiceFactory.getLibroServiceInstance();

		// questa variabile mi serve in quanto sfrutto in un colpo la validazione
		// della data ed il suo parsing che non posso fare senza un try catch
		// a questo punto lo incapsulo in un metodo apposito
		Date dataPubblicazioneParsed = UtilityArticoloForm.parseDateArrivoFromString(dataPubblicazioneStringParam);

		// valido input tramite apposito metodo e se la validazione fallisce torno in
		// pagina
		if (!UtilityArticoloForm.validateInput(titoloInputParam, genereInputParam, pagineInputStringParam,
				dataPubblicazioneStringParam) || dataPubblicazioneParsed == null) {

			Integer provvisorio = 0;
			if (!pagineInputStringParam.isEmpty()) {
				provvisorio = Integer.parseInt(pagineInputStringParam);
			}
			request.setAttribute("modifica_libro_attr", new Libro(Long.parseLong(idLibroParam), titoloInputParam,
					genereInputParam, provvisorio, dataPubblicazioneParsed));
			request.setAttribute("errorMessage", "Attenzione sono presenti errori di validazione");
			request.getRequestDispatcher("/libro/modifica.jsp").forward(request, response);
			return;
		}

		try {
			Libro libroInstance = serviceLibro.caricaSingoloElemento(Long.parseLong(idLibroParam));
			libroInstance.setTitolo(titoloInputParam);
			libroInstance.setDataPubblicazione(dataPubblicazioneParsed);
			libroInstance.setGenere(genereInputParam);
			libroInstance.setPagine(Integer.parseInt(pagineInputStringParam));
			serviceLibro.aggiorna(libroInstance);
			request.setAttribute("listaLibriAttribute", MyServiceFactory.getLibroServiceInstance().listAll());
			request.setAttribute("successMessage", "Operazione effettuata con successo");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/libro/modifica.jsp").forward(request, response);
			return;
		}

		// andiamo ai risultati
		request.getRequestDispatcher("/libro/results.jsp").forward(request, response);

	}

}
