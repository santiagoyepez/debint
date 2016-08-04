package rest;

import java.sql.SQLException;

import javax.ws.rs.*;

import modelo.datos.DatosSolicitudRecurso;
import modelo.operacion.TablaSolicitudRecurso;

@Path("/recurso")
@Produces("application/json")
public class SrvRecurso {

	@GET
	@Path("/solicitar/{recurso}/{comentario}")
	public static String solicitar(@PathParam("recurso") String recurso, @PathParam("comentario") String comentario){
		String ret = "solicitud correcta";
		
		DatosSolicitudRecurso dsr = new DatosSolicitudRecurso();
		dsr.setComentario(comentario);
		dsr.setRecursoSolicitado(recurso);
		dsr.setPuntos(1);
		
		try {
			TablaSolicitudRecurso tsr = new TablaSolicitudRecurso();
			if (!tsr.insertar(dsr)) ret = "error en la solicitud";
		} catch (SQLException e) {
			ret = "error en la solicitud";
		}
		
		return ret;
	}
}
