<%@page import="modelo.datos.DatosCarrera"%>
<% String tituloPagina="Panel de administración"; %>
<%@include file="/vistas/comunes/header.jsp"%>
<%@ page import="java.util.List" %>
	<h2>Carreras</h2>
	<p>
		<mark>Resultado: <%= request.getAttribute("retCreacionCarrera") %> </mark> 
		<form action="../../CrearCarreraCtrl" method="post">
			Nombre de la carrera: <input type="text" name="nombreCarrera">
			<input type="submit" value="Crear">
		</form>
	</p>
	<p>
		<form action="../../ListarCarrerasCtrl" method="post">
			<input type="submit" value="Listar carreras">
		</form>
		<table>
			<tr>
				<th>Id</th>
				<th>Nombre de carrera</th>
			</tr>
			<%
			List<DatosCarrera> listaCarreras = (List<DatosCarrera>) request.getAttribute("listaCarreras");
			if (listaCarreras != null){
				for(DatosCarrera dc: listaCarreras) {
			%>
			<tr>
				<td><%= dc.getIdCarrera() %></td>
				<td><%= dc.getCarrera() %></td>
			</tr>
			<%
				}
			}
			%>
		</table>
	</p>
	<h2>Materias</h2>
	<p>
		<mark>Resultado: <%= request.getAttribute("retCreacionMateria") %> </mark> 
		<form action="../../CrearMateriaCtrl" method="post">
			Carrera (id): <input type="text" name="idCarrera">
			Nombre de la materia: <input type="text" name="nombreCarrera">
			<input type="submit" value="Crear">
		</form>
	</p>
<%@include file="/vistas/comunes/footer.jsp"%>