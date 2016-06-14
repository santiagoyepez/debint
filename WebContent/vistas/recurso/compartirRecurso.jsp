<% String tituloPagina="Compartir recurso"; %>
<%@include file="/vistas/comunes/header.jsp"%>

<div class="row">
                    <div class="col-lg-12">
                    <%
			
			if(request.getAttribute("ret")!=null){
				out.print("<div class=\"alert alert-success\" role=\"alert\">"+request.getAttribute("ret")+"</div>");
			}
		
		%>
<form action="../../CompartirRecursoCtrl" method="post" enctype="multipart/form-data">
	<div class="form-group">
    	<label>Titulo:</label>
    	<input type="text" name="titulo" class="form-control"/>
  	</div>
  	
  	<div class="form-group">
    	<label>Descripcion:</label>
    	<input type="text" name="descripcion" class="form-control"/>
  	</div>

	<div class="form-group">	
		<input type="file" name="files" id="files"/>
	</div>
	
	<input type="submit" value="Subir" class="btn btn-primary"/>
</form>
                    </div>
                </div>
                <!-- /.row -->
                
<%@include file="/vistas/comunes/footer.jsp"%>