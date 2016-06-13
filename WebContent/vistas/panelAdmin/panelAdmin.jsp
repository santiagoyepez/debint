<%@page import="modelo.datos.DatosMateria"%>
<%@page import="modelo.datos.DatosBdD"%>
<%@page import="modelo.datos.DatosCarrera"%>
<% String tituloPagina="Panel de administración"; %>
<%@include file="/vistas/comunes/header.jsp"%>
<%@ page import="java.util.List" %>
	<h2>Carreras</h2>
	<p>
		<h3>Crear carrera</h3>
		<mark>Resultado: <%= request.getAttribute("retCreacionCarrera") %> </mark> 
		<form action="../../CrearCarreraCtrl" method="post">
			Nombre de la carrera: <input type="text" name="nombreCarrera">
			<input type="submit" value="Crear">
		</form>
	</p>
	<p>	
		<h3>Listado de carreras</h3>
		<form action="../../ListarCarrerasCtrl" method="post">
			<input type="submit" value="Listar carreras">
		</form>
		<table>
			<tr>
				<th>Id</th>
				<th>Nombre de carrera</th>
			</tr>
			<%
			List<DatosBdD> listaCarreras = (List<DatosBdD>) request.getAttribute("listaCarreras");
			if (listaCarreras != null){
				for(DatosBdD d: listaCarreras) {
					DatosCarrera dc = (DatosCarrera) d;
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
		<h3>Crear materia</h3>
		<mark>Resultado: <%= request.getAttribute("retCreacionMateria") %> </mark> 
		<form action="../../CrearMateriaCtrl" method="post">
			Carrera (id): <input type="text" name="idCarrera">
			Nombre de la materia: <input type="text" name="nombreMateria">
			<input type="submit" value="Crear">
		</form>
	</p>
	<p>
		<h3>Listado de materias</h3>
		<form action="../../ListarMateriasCtrl" method="post">
			Carrera (id): <input type="text" name="idCarrera">
			<input type="submit" value="Listar materias">
		</form>
		<table>
			<tr>
				<th>idMateria</th>
				<th>idCarrera</th>
				<th>Materia</th>
			</tr>
			<%
			List<DatosMateria> listaMaterias = (List<DatosMateria>) request.getAttribute("listaMaterias");
			if (listaMaterias != null){
				for(DatosMateria dm: listaMaterias) {
			%>
			<tr>
				<td><%= dm.getIdMateria() %></td>
				<td><%= dm.getIdCarrera() %></td>
				<td><%= dm.getMateria() %></td>
			</tr>
			<%
				}
			}
			%>
		</table>
	</p>
<%@include file="/vistas/comunes/footer.jsp"%>