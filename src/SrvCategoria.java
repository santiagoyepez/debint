import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import model.Categoria;
import operador.TablaCategoria;

@Path("/categoria")
@Produces("application/json")
public class SrvCategoria {
	@POST
	@Path("/registrar")
	@Consumes("application/json")
	public String registrar(Categoria c){
		String ret = "categoria registrada";
		if (!TablaCategoria.insertar(c)) ret = "error registro categoria";
		return ret;
	}
	
	@GET
	@Path("/listar")
	public List<Categoria> listar(){
		return TablaCategoria.listar();
	}
	
	@GET
	@Path("/consultar/{idCategoria}")
	public Categoria consultar(@PathParam("idCategoria") int idCategoria){
		return TablaCategoria.consultarPorId(idCategoria);
	}
}
