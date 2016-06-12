<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, ec.edu.epn.modelo.Usuario" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Hi</h1>
	
	<% String tituloPagina="Administración de Locales"; %>
   <%@include file="../commons/header.jsp" %>
   
   
    
     <a href="crearUsuario.jsp">Crear Usuario</a>
     <a href="ingresarUsuario.jsp">Ingresar</a>
     
     
     <h2>Buscar Usuario</h2>
     <form action="BuscarUsuarioCtrl" method="get">
     Nombre: <input type="text" name="nombreBusqueda" /> 
	<input type="submit" value="Buscar">
	</form>
	
	<table>
		<tr>
		<th>Id</th>
		<th>Nombre</th>
		</tr>
		<%
		List<Usuario> usuarios = (List<Usuario>)request.getAttribute("USUARIOS");
		if(usuarios != null){
			for(Usuario u: usuarios){
				%>
				<tr>
					<td><%= u.getId() %></td>
					<td><%= u.getUsername() %></td>
					<td><a href = "/adm/ActualizarUsuarioCtrl?id=<%= u.getId() %>">Actualizar</a></td>
					
				</tr>
					<%
				
			}
		}
		%>
		
	</table>
	
	
	
	
</body>
</html>