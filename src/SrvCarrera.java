import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import model.Carrera;
import operador.TablaCarrera;

@Path("/carrera")
@Produces("application/json")
public class SrvCarrera {
	@POST
	@Path("/registrar")
	@Consumes("application/json")
	public String registrar(Carrera c){
		String ret = "carrera registrada";
		if (!TablaCarrera.insertar(c)) ret = "error registro carrera";
		return ret;
	}
	
	@GET
	@Path("/listar")
	public List<Carrera> listar(){
		return TablaCarrera.listar();
	}
	
	@GET
	@Path("/consultar/{idCarrera}")
	public Carrera consultar(@PathParam("idCarrera") int idCarrera){
		return TablaCarrera.consultarPorId(idCarrera);
	}
}