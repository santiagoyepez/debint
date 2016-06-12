package ec.edu.epn.controlador;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.epn.modelo.Usuario;
import ec.edu.epn.modelo.servicios.GestorUsuarios;

/**
 * Servlet implementation class CrearUsuarioCtrl
 */
@WebServlet("/adm/CrearUsuarioCtrl")
public class CrearUsuarioCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrearUsuarioCtrl() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Preparamos informacion
		String nombre = request.getParameter("txtNombre");
		String password = request.getParameter("txtPassword");
		
		Usuario usuario = new Usuario();
		usuario.setUsername(nombre);
		usuario.setPassword(password);
		
		//Llamar al modelo
		GestorUsuarios gu = new GestorUsuarios();
		
		String resultado = "";
		
		try{
			gu.crearUsuario(usuario);
			resultado = "Exito";
		}catch(Exception e){
			resultado = "Error" + e.getMessage();
			e.printStackTrace();
		}
		
		//Publicar los datos dados por el modelo
		request.setAttribute("RESULTADO", resultado);
		
		//Redireccionar a la vista
		RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/adm/crearUsuario.jsp");
		
		rd.forward(request, response);
		
	}

}
