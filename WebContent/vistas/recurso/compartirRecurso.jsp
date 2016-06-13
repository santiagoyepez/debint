<% String tituloPagina="Compartir recurso"; %>
<%@include file="/vistas/comunes/header.jsp"%>
<mark>Resultado: <%= request.getAttribute("ret") %> </mark> 
<form action="../../CompartirRecursoCtrl" method="post" enctype="multipart/form-data">
	Titulo: <input type="text" name="titulo"/>
	Descripcion: <input type="text" name="descripcion"/>	
	<input type="file" name="files" id="files"/>
	<input type="submit" value="Subir"/>
</form>
<%@include file="/vistas/comunes/footer.jsp"%>