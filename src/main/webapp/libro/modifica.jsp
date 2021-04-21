<!doctype html>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="it.prova.applicazioneweblibri.model.Libro"%>
<html lang="it">
<head>
	<jsp:include page="../header.jsp" />
	<title>Modifica Articolo</title>
	
	<!-- style per le pagine diverse dalla index -->
    <link href="./assets/css/global.css" rel="stylesheet">
    
</head>
<body>
	<jsp:include page="../navbar.jsp" />
	
	<main role="main" class="container">
	
		<div class="alert alert-danger alert-dismissible fade show ${errorMessage==null?'d-none': ''}" role="alert">
		  ${errorMessage}
		  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
		    <span aria-hidden="true">&times;</span>
		  </button>
		</div>
		
		<% Libro libroInPagina = (Libro)request.getAttribute("modifica_libro_attr"); %>
		
		<div class='card'>
		    <div class='card-header'>
		        <h5>Modifica il libro</h5> 
		    </div>
		    <div class='card-body'>

					<h6 class="card-title">I campi con <span class="text-danger">*</span> sono obbligatori</h6>

					<form method="post" action="ExecuteModificaLibroServlet" novalidate="novalidate">
					
						<div class="form-row">
							<div class="form-group col-md-6">
								<label>Titolo <span class="text-danger" >*</span></label>
								<input type="text" name="titolo" id="titolo" class="form-control" value="<%=libroInPagina.getTitolo()!=null?libroInPagina.getTitolo():"" %>" required>
							</div>
							
							<div class="form-group col-md-6">
								<label>Descrizione <span class="text-danger">*</span></label>
								<input type="text" name="genere" id="genere" class="form-control" value="<%=libroInPagina.getGenere()!=null?libroInPagina.getGenere():"" %>" required>
							</div>
						</div>
						
						<div class="form-row">	
							<div class="form-group col-md-6">
								<label>Prezzo <span class="text-danger">*</span></label>
								<input type="number" class="form-control" name="pagine" id="pagine" value="<%=libroInPagina.getPagine()!=null?libroInPagina.getPagine():"" %>" required>
							</div>
							<div class="form-group col-md-3">
								<label>Data di Arrivo<span class="text-danger">*</span></label>
                        		<input class="form-control" id="dataArrivo" type="date"  value = "<%=libroInPagina.getDataPubblicazione()!=null? new SimpleDateFormat("yyyy-MM-dd").format(libroInPagina.getDataPubblicazione()):""%>"
                            		title="formato : gg/mm/aaaa"  name="dataPubblicazione" required>
							</div>
							
						</div>
							
						<button type="submit" name="submit" value="submit" id="submit" class="btn btn-primary">Conferma</button>
					
						<input type="hidden"   name="idLibro"   value="<%= libroInPagina.getId()%>">

					</form>

		    
		    
			<!-- end card-body -->			   
		    </div>
		</div>	
	
	
	<!-- end container -->	
	</main>
	<jsp:include page="../footer.jsp" />
	
</body>
</html>