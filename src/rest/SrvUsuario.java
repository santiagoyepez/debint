package rest;

import java.util.GregorianCalendar;
import java.util.List;

import javax.ws.rs.*;

import model.Usuario;
import modelo.operacion.TablaUsuario;

@Path("/usuario")
@Produces("application/json")
public class SrvUsuario {

	
	/*@GET
	@Path("/registrar/{nombre}/{apellido}/{alias}/{clave}")
	public String registrar(@PathParam("nombre") String nombre, @PathParam("apellido") String apellido, @PathParam("alias") String alias, @PathParam("clave") String clave){}*/
	@POST
	@Path("/registrar")
	@Consumes("application/json")
	public String registrar(Usuario u){
		String ret = "registro correcto";
		/*Usuario u = new Usuario();
		u.setAlias(alias);
		u.setNombre(nombre);
		u.setContraseña(clave);
		u.setApellido(apellido);
		u.setFechaRegistro(new GregorianCalendar().getTime());*/
		if (!TablaUsuario.registrar(u)) ret = "error registro";
		return ret;
	}
	
	@GET
	@Path("/consultar/{alias}")
	public List<Usuario> consultar(@PathParam("alias") String alias){
		return TablaUsuario.consultarPorAlias(alias);
	}
}
