<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="ec.edu.epn.modelo.Usuario" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% String tituloPagina = "Actualizar Usuario"; %>
	<%@include file="../commons/header.jsp" %>
	
	<mark> Resultado: <%= request.getAttribute("RESULTADO") %></mark>
	
	<%
	Usuario usuario = (Usuario) request.getAttribute("USUARIO");
	%>
	
	<form method="post" action="ActualizarUsuarioCtrl">
	Id: <%= usuario.getId() %>
	Nombre: <input type="text" name="txtNombre" value="<%= usuario.getUsername() %>"/>
	Password: <input type="text" name="txtPassword" value="<%= usuario.getPassword() %>"/>
	
	<input type="submit" value="Guardar"/>
	
	</form>
	

</body>
</html>