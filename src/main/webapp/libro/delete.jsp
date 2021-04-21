<!doctype html>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="it.prova.applicazioneweblibri.model.Libro"%>
<html lang="it">
<head>
	<jsp:include page="../header.jsp" />
	<title>Elimina elemento</title>
	
	<!-- style per le pagine diverse dalla index -->
    <link href="./assets/css/global.css" rel="stylesheet">
    
</head>
<body>
	<jsp:include page="../navbar.jsp" />
	
	<main role="main" class="container">
		
		<div class='card'>
		    <div class='card-header'>
		        Visualizza dettaglio del libro da eliminare
		    </div>
		    <% Libro libroInPagina = (Libro)request.getAttribute("elimina_libro_attr"); %>
		
		    <div class='card-body'>
		    	<dl class="row">
				  <dt class="col-sm-3 text-right">Codice</dt>
				  <dd class="col-sm-9"><%=libroInPagina.getTitolo() %></dd>
		    	</dl>
		    	
		    	<dl class="row">
				  <dt class="col-sm-3 text-right">Descrizione:</dt>
				  <dd class="col-sm-9"><%=libroInPagina.getGenere() %></dd>
		    	</dl>
		    	
		    	<dl class="row">
				  <dt class="col-sm-3 text-right">Prezzo:</dt>
				  <dd class="col-sm-9"><%=libroInPagina.getPagine() %></dd>
		    	</dl>
		    	
		    	<dl class="row">
				  <dt class="col-sm-3 text-right">Data di Arrivo:</dt>
				  <dd class="col-sm-9"><%=libroInPagina.getDataPubblicazione()!=null? new SimpleDateFormat("dd/MM/yyyy").format(libroInPagina.getDataPubblicazione()):"N.D."  %></dd>
		    	</dl>
		    	
		    </div>
		    
		    <div class='card-footer'>
		    
		    	<form action="ExecuteRimuoviLibroServlet" method="post"   >
			        <a href="ListLibriServlet" class='btn btn-outline-secondary' style='width:80px'>
			            <i class='fa fa-chevron-left'></i> Back
			        </a>
		        
		        	<input type="hidden"   name="idLibro"   value="<%= libroInPagina.getId()%>">
		        	<button type="submit" class='btn btn-outline-secondary' style='color: black;background-color: red'>Elimina</button>
		        
		        </form>
		        
		        
		    </div>
		    
		    
		 </div>	
	
	
	
	<!-- end main container -->	
	</main>
	<jsp:include page="../footer.jsp" />
	
</body>
</html>