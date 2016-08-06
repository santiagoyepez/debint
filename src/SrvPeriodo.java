import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import model.Periodo;
import model.Recurso;
import operador.TablaPeriodo;
import operador.TablaRecurso;

@Path("/periodo")
@Produces("application/json")
public class SrvPeriodo {
	@POST
	@Path("/registrar")
	@Consumes("application/json")
	public String registrar(Periodo p){
		String ret = "periodo registrado";
		if (!TablaPeriodo.insertar(p)) ret = "error registro periodo";
		return "{\"mensaje\":\"" + ret + "\"}";
	}
	
	@GET
	@Path("/listar")
	public List<Periodo> listar(){
		return TablaPeriodo.listar();
	}
	
	@GET
	@Path("/consultar/{idPeriodo}")
	public Periodo consultar(@PathParam("idPeriodo") int idPeriodo){
		return TablaPeriodo.consultarPorId(idPeriodo);
	}
	
	@POST
	@Path("/eliminar/{idPeriodo}")
	public String eliminar(@PathParam("idPeriodo") int idPeriodo){
		TablaPeriodo.eliminar(idPeriodo);
		return "{\"mensaje\":\"correcto\"}";
	}
}
