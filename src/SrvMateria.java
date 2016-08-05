import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import model.Materia;
import operador.TablaCarrera;
import operador.TablaMateria;

@Path("/materia")
@Produces("application/json")
public class SrvMateria {
	@POST
	@Path("/registrar")
	@Consumes("application/json")
	public String registrar(Materia m){
		String ret = "materia registrada";
		if (!TablaMateria.insertar(m)) ret = "error registro materia";
		return ret;
	}
	
	@GET
	@Path("/listar")
	public List<Materia> listar(){
		return TablaMateria.listar();
	}
	
	@GET
	@Path("/consultar/{idMateria}")
	public Materia consultar(@PathParam("idMateria") int idMateria){
		return TablaMateria.consultarPorId(idMateria);
	}
}
