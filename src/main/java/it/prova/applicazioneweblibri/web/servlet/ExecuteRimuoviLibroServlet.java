package it.prova.applicazioneweblibri.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.math.NumberUtils;

import it.prova.applicazioneweblibri.model.Libro;
import it.prova.applicazioneweblibri.service.LibroService;
import it.prova.applicazioneweblibri.service.MyServiceFactory;

@WebServlet("/ExecuteRimuoviLibroServlet")
public class ExecuteRimuoviLibroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ExecuteRimuoviLibroServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idLibroParam = request.getParameter("idLibro");
		System.out.println(idLibroParam);

		LibroService serviceArticolo = MyServiceFactory.getLibroServiceInstance();

		if (!NumberUtils.isCreatable(idLibroParam)) {
			// qui ci andrebbe un messaggio nei file di log costruito ad hoc se fosse attivo
			request.setAttribute("errorMessage", "Attenzione si è verificato un erroreeeee.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}

		try {
			Libro libroDaEliminare = serviceArticolo.caricaSingoloElemento(Long.parseLong(idLibroParam));
			serviceArticolo.rimuovi(libroDaEliminare);
			request.setAttribute("listaLibriAttribute", MyServiceFactory.getLibroServiceInstance().listAll());
			request.setAttribute("successMessage", "Operazione effettuata con successo");
		} catch (Exception e) {
			// qui ci andrebbe un messaggio nei file di log costruito ad hoc se fosse attivo
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}

		request.getRequestDispatcher("/libro/results.jsp").forward(request, response);
	}

}
