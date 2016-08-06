import java.util.List;

import javax.ws.rs.*;

import model.Categoria;
import model.Recurso;
import operador.TablaCategoria;
import operador.TablaRecurso;
import operador.TablaSolicitudRecurso;
import operador.TablaUsuario;

@Path("/recurso")
@Produces("application/json")
public class SrvRecurso {

	@POST
	@Path("/registrar")
	@Consumes("application/json")
	public String registrar(Recurso r){
		String ret = "recurso registrado";
		if (!TablaRecurso.insertar(r)) ret = "error registro recurso";
		return "{\"mensaje\":\"" + ret + "\"}";
	}
	
	@GET
	@Path("/listar")
	public List<Recurso> listar(){
		return TablaRecurso.listar();
	}
	
	@GET
	@Path("/consultar/{idRecurso}")
	public List<Recurso> consultar(@PathParam("idRecurso") int idRecurso){
		return TablaRecurso.consultarPorId(idRecurso);
	}
	
	@GET
	@Path("/consultarPorCategoria/{idCategoria}")
	public List<Recurso> consultarPorCategoria(@PathParam("idCategoria") int idCategoria){
		return TablaRecurso.consultarPorCategoria(idCategoria);
	}
	
	@GET
	@Path("/consultarPorTitulo/{titulo}")
	public List<Recurso> consultarPorTitulo(@PathParam("titulo") String titulo){
		return TablaRecurso.consultarPorTitulo(titulo);
	}
}