import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import model.SolicitudRecurso;
import operador.TablaSolicitudRecurso;

@Path("/solicitudRecurso")
@Produces("application/json")
public class SrvSolicitudRecurso {
	@POST
	@Path("/registrar")
	@Consumes("application/json")
	public String registrar(SolicitudRecurso sr){
		String ret = "solicitud registrada";
		if (!TablaSolicitudRecurso.insertar(sr)) ret = "error registro solicitud";
		return ret;
	}
	
	@GET
	@Path("/listar")
	public List<SolicitudRecurso> listar(){
		return TablaSolicitudRecurso.listar();
	}
}
