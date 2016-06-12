<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Respositorio de Deberes</title>
<link rel="stylesheet" href="estilos/estilo.css">
<link rel="stylesheet" href="depen/boot/css/bootstrap.css">
</head>
<body>
	
   
      <nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a href="http://localhost:8080/usuario/">

                    
                    <img style="max-height: 40px" src="imagenes/lo.png" alt="Logo Sistema">
                    

                </a>
            </div>
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="http://localhost:8080/usuario/">Inicio <span class="sr-only">(current)</span></a></li>
                    <li><a href="#">Quienes Somos</a></li>
                    <li><a href="#">Recursos Compartidos</a></li>
                    <li><a href="#">Contacto</a></li>

                </ul>

                <ul class="nav navbar-nav navbar-right">
                    <li>
                    <button type="button" class="btn btn-danger btn-md"><a href="adm/ingresarUsuario.jsp">Ingresar</a></button>
                        
                    </li>
                </ul>
            </div>
        </div>


    </nav>
   
	
    <div>
        <center><img src="imagenes/mundo.jpg" class="img-responsive" alt="Cinque Terre"> </center>

    </div>



 
   
   <footer>
      <%@include file="commons/footer.jsp" %>
      <script src="depen/jquery/jquery-2.1.4.min.js"></script>
    <script src="depen/boot/js/bootstrap.js"></script>
   </footer>
   
</body>
</html>