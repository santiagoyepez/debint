<%@page import="modelo.datos.DatosMateria"%>
<%@page import="modelo.datos.DatosBdD"%>
<%@page import="modelo.datos.DatosCarrera"%>
<% String tituloPagina="Panel de administración"; %>
<%@include file="/vistas/comunes/header.jsp"%>
<%@ page import="java.util.List" %>
<div class="row">
 <div class="col-lg-12">
	<h2>Carreras</h2>
	<p>
		<h3>Crear carrera</h3>
		<%
			if(request.getAttribute("retCreacionCarrera")!=null){
				out.print("<div class=\"alert alert-success\" role=\"alert\">"+request.getAttribute("retCreacionCarrera")+"</div>");
			}
		
		%>
		<form action="/debint/CrearCarreraCtrl" method="post">
			  	<div class="form-group">
			    	<label>Nombre de la carrera:</label>
			    	<input type="text" name="nombreCarrera" class="form-control"/>
			  	</div>
			  	
			<input type="submit" value="Crear" class="btn btn-primary">
		</form>
	</p>
	<p>	
		<h3>Listado de carreras</h3>
		<form action="../../ListarCarrerasCtrl" method="post">
			<input type="submit" value="Listar carreras" class="btn btn-primary">
		</form> 
		<table class="table table-striped">
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
		<%
			
			if(request.getAttribute("retCreacionMateria")!=null){
				out.print("<div class=\"alert alert-success\" role=\"alert\">"+request.getAttribute("retCreacionMateria")+"</div>");
			}
		
		%>
		<form action="/debint/CrearMateriaCtrl" method="post">
		<div class="form-group">
	    	<label>Carrera (id):</label>
	    	<input type="text" name="idCarrera" class="form-control"/>
	  	</div>
	  	
	  	<div class="form-group">
	    	<label>Nombre de la materia:</label>
	    	<input type="text" name="nombreMateria" class="form-control"/>
	  	</div>

			<input type="submit" value="Crear" class="btn btn-primary">
		</form>
	</p>
	<p>
		<h3>Listado de materias</h3>
		<form action="../../ListarMateriasCtrl" method="post">
		  	<div class="form-group">
		    	<label>Carrera (id):</label>
		    	<input type="text" name="idCarrera" class="form-control"/>
		  	</div>
		  	

			<input type="submit" value="Listar materias" class="btn btn-primary">
		</form>
		<table class="table table-striped">
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
	</div>
	</div>
<%@include file="/vistas/comunes/footer.jsp"%>