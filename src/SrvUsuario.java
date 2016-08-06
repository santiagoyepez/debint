import java.util.GregorianCalendar;
import java.util.List;

import javax.ws.rs.*;

import model.Usuario;
import operador.TablaUsuario;

@Path("/usuario")
@Produces("application/json")
public class SrvUsuario {
	@POST
	@Path("/registrar")
	@Consumes("application/json")
	public String registrar(Usuario u){
		String ret = "registro correcto";
		if (!TablaUsuario.registrar(u)) ret = "error registro";
		return "{\"mensaje\":\"" + ret + "\"}";
	}
	
	@GET
	@Path("/consultarPorAlias/{alias}")
	public List<Usuario> consultarPorAlias(@PathParam("alias") String alias){
		return TablaUsuario.consultarPorAlias(alias);
	}
}
