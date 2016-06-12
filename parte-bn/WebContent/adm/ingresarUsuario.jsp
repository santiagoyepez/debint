<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="../commons/header.jsp" %>
	<br>
    <br>
    <br>
    <br>
    <br>
    <center><div class="alert alert-danger" role="succes" style="margin-left:auto;margin-right:auto; display: <%= request.getAttribute("Resultado") == null ? "none": "inline" %> ">
		  <%=  request.getAttribute("Resultado") %>
		</div></center>
    
    <br>
    <br>
	<div class="col-sm-4">
        <!--CONTENEDOR IZQUIERDO-->
    </div>

    <div id="form" class="col-sm-4 animated flip">
        <!--       EMPIEZA EL CONTENEDOR DE LA MITAD-->


        
        
        <form method="post" action="IngresarUsuarioCtrl">
	    
	   
	   
	
	   
	
        
            <br>
            <div id="sig"><span class="glyphicon glyphicon-user" aria-hidden="true"></span> &nbsp;&nbsp;Iniciar Sesión</div>

            <br>
            <br>
            <br>

            
                <div class="form-group">
                    
                    <input type="text" name="username"  placeholder="Usuario"/>
                </div>
            
            
                <div class="form-group" >
                    
                    <input type="password" name="password" placeholder="Contrase&#241a" />
                </div>
            
            <input type="submit" value="Ingresar" />
            <button type="button" class="btn btn-danger btn-md"><a href="crearUsuario.jsp">Registrarse</a></button>
            
            
            <div>
            <p></p>
            
            </div>
        </form>
    </div>
    <div class="form-group">
		
    </div>
    

    
</body>
</html>