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

<h1>Peticion</h1>

<% String tituloPagina="Crear Peticion"; %>
   <%@include file="index.jsp" %>

   <mark> Resultado: <%= request.getAttribute("RESULTADO") %> </mark> 
   
   

	<form method="post" action="CrearPeticionCtrl">
	
	
	   Asunto: <input type="text" name="txtAsunto" />
	   
	    
	   
	   id:<input type="text" name="txtid">
	   
	
	   <input type="submit" value="Crear" />
	</form>
	
	
	</body>
</html>