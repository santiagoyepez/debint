<% String tituloPagina="Panel de administración"; %>
<%@include file="/vistas/comunes/header.jsp"%>
	<h2>
		Carreras
	</h2>
	<p>
		<mark>Resultado: <%= request.getAttribute("retCreacionCarrera") %> </mark> 
		<form action="../../CrearCarreraCtrl" method="post">
			Nombre de la carrera: <input type="text" name="nombreCarrera">
			<input type="submit" value="Crear">
		</form>
	</p>
<%@include file="/vistas/comunes/footer.jsp"%>