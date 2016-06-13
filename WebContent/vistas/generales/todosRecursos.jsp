<%@page import="modelo.datos.DatosRecurso"%>
<%@page import="modelo.datos.DatosBdD"%>
<% String tituloPagina="Recursos Disponibles"; %>
<%@include file="/vistas/comunes/header.jsp"%>
<%@ page import="java.util.List" %>

<form action="../../ListarRecursosCtrl" method="post">
			<input type="submit" value="Listar recursos">
		</form>

                	<div class="row">
                    <div class="col-lg-12">
                        <div class="panel-group">
                        
                        	<%
			List<DatosBdD> listaRecursos = (List<DatosBdD>) request.getAttribute("listaRecursos");
			if (listaRecursos != null){
				for(DatosBdD d: listaRecursos) {
					DatosRecurso dr = (DatosRecurso) d;
			%>			
			<div class="col-md-6">
							    <div class="panel panel-primary">
							      <div class="panel-heading"><%= dr.getTitulo() %></div>
							      <div class="panel-body">
							      	<p>Descripción:
							      	<br><%= dr.getDescripcion() %></p>
							      	
							      	<p>Archivo:
							      	<br><%= dr.getNombreArchivo() %></p>
							      	<a href="http://localhost:8080/debint/subidas/<%= dr.getNombreArchivo()%>" download="<%= dr.getNombreArchivo() %>">
										Descargar Archivo
									</a>
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
							      	<p>Descripción:
							      	<br>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent vehicula ut quam placerat rhoncus. Integer sagittis nibh et nunc tincidunt varius. Sed sapien nisi, elementum et accumsan sit amet, placerat eu diam. In hac habitasse platea dictumst.</p>
							      	
							      	<p>Carrera:
							      	<br>Ingeniería en Sistemas</p>
							      	
							      	<p>Materia:
							      	<br>Aplicaciones Web</p>
							      	
							      	<p>Periodo:
							      	<br>2016-A</p>
							      	
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