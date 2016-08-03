package rest;

import java.util.GregorianCalendar;

import javax.ws.rs.*;

import model.Usuario;
import modelo.operacion.TablaUsuario;

@Path("/usuario")
@Produces("application/json")
public class SrvUsuario {

	@GET
	/*@Path("/registrar")
	@Consumes("application/json")*/
	@Path("/registrar/{nombre}/{apellido}/{alias}/{clave}")
	public String registrar(@PathParam("nombre") String nombre, @PathParam("apellido") String apellido, @PathParam("alias") String alias, @PathParam("clave") String clave){
		String ret = "registro correcto";
		Usuario u = new Usuario();
		u.setAlias(alias);
		u.setNombre(nombre);
		u.setContraseña(clave);
		u.setApellido(apellido);
		u.setFechaRegistro(new GregorianCalendar().getTime());
		if (!TablaUsuario.registrar(u)) ret = "error registro";
		return ret;
	}
}
