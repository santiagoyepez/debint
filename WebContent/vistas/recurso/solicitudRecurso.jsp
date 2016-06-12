<% String tituloPagina="Compartir recurso"; %>
<%@include file="/vistas/comunes/header.jsp"%>
<form action="../../SolicitarRecursoCtrl" method="post">
	Recurso solicitado: <input type="text" name="recursoSolicitado">
	Comentario: <input type="text" name="comentario">	
	<input type="submit" value="Solicitar">
</form>
<%@include file="/vistas/comunes/footer.jsp"%>