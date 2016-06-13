<%@ page import="java.util.List, model.Periodo" %>
<% String tituloPagina="Administración de Periodos Académicos"; %>
<%@include file="/vistas/comunes/header.jsp"%>
<div class="container-fluid">
	<div class="container">
		<div class="col-md-12">
			<h2>Agregar nuevo periodo académico</h2>
		<%
			
			if(request.getAttribute("respuesta")!=null){
				out.print("<div class=\"alert alert-success\" role=\"alert\">"+request.getAttribute("respuesta")+"</div>");
			}
		
		%>
			<form action="periodoAgregarPeriodo" method="post">
				<div class="form-group">
					<label>Año</label>
					<input type="number" class="form-control" name="ano" placeholder="yyyy" value="2016">
				</div>
				
				<div class="form-group">
					<label>Periodo</label>
					<select name="parte" class="form-control">
					  <option>A</option>
					  <option>B</option>
					  <option>R</option>
					</select>
				</div>
				
				<button type="submit" class="btn btn-primary">Agregar</button>
			</form>
		</div>
		
		<div class="col-md-12">
			<h2>Periodos Académicos Registrados</h2>
			<table class="table table-striped">
				<tr>
				    <th>Año</th>
				    <th>Periodo</th>
				    <th>Eliminar</th>
				</tr>
				
					<%
						List<Periodo> periodosRecibidos = (List<Periodo>)request.getAttribute("periodosEncontrados");
					if(periodosRecibidos!=null){

						for(Periodo p: periodosRecibidos){

					%>
						<tr>
				    		<td><%= p.getAño()%></td>
				    		<td><%= p.getParte().toString()%></td>
				    		<td><a class="btn btn-default" href="periodoEliminarPeriodo?id=<%= p.getIdPeriodo() %>">Eliminar</a></td>
						</tr>
						
					<% 	
						}	
					}
					%>
				
			</table>
		</div>
		
		
	</div>
</div>
<%@include file="/vistas/comunes/footer.jsp"%>