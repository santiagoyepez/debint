<% String tituloPagina="Solicitar recurso"; %>
<%@include file="/vistas/comunes/header.jsp"%>
    <%
			
			if(request.getAttribute("ret")!=null){
				out.print("<div class=\"alert alert-success\" role=\"alert\">"+request.getAttribute("ret")+"</div>");
			}
		
		%>
<form action="../../SolicitarRecursoCtrl" method="post">
	<div class="form-group">
    	<label>Recurso solicitado:</label>
    	<input type="text" name="recursoSolicitado" class="form-control"/>
  	</div>
  	
  	<div class="form-group">
    	<label>Comentario:</label>
    	<input type="text" name="comentario" class="form-control"/>
  	</div>

	<input type="submit" value="Solicitar" class="btn btn-primary">
</form>
<%@include file="/vistas/comunes/footer.jsp"%>