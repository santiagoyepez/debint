<%@page import="modelo.datos.DatosSolicitudRecurso"%>
<%@page import="modelo.datos.DatosBdD"%>
<% String tituloPagina="Solicitudes de recursos"; %>
<%@include file="/vistas/comunes/header.jsp"%>
<%@ page import="java.util.List" %>

                	<div class="row">
                    <div class="col-lg-12">
                        <div class="panel-group">
                        
                        <%
			List<DatosBdD> listaRecursos = (List<DatosBdD>) request.getAttribute("listaSolicitudes");
			if (listaRecursos != null){
				for(DatosBdD d: listaRecursos) {
					DatosSolicitudRecurso dsr = (DatosSolicitudRecurso) d;
			%>
                        
						    <div class="col-md-6">
							    <div class="panel panel-primary">
							      <div class="panel-heading"><%= dsr.getRecursoSolicitado() %></div>
							      <div class="panel-body">
							      	<p>Comentario:
							      	<br><%= dsr.getComentario() %></p>
							      </div>
							    </div>
						    </div>
			<%
				}
			}
			%>
			<!-- 
						    <div class="col-md-6">
							    <div class="panel panel-primary">
							      <div class="panel-heading">JPA</div>
							      <div class="panel-body">
							      	<p>Comentario:
							      	<br>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent vehicula ut quam placerat rhoncus. Integer sagittis nibh et nunc tincidunt varius. Sed sapien nisi, elementum et accumsan sit amet, placerat eu diam. In hac habitasse platea dictumst.</p>
							      								      	
							      	<a href="#" class="btn btn-primary">Leer Más</a>
							      </div>
							    </div>
						    </div>
			-->		    
</div>
                    </div>
                </div>
                <!-- /.row -->
 <%@include file="/vistas/comunes/footer.jsp"%>