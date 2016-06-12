package ec.edu.epn.controlador;

import java.io.IOException;
import java.util.List;

import javax.persistence.metamodel.SetAttribute;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ec.edu.epn.modelo.Usuario;
import ec.edu.epn.modelo.servicios.GestorUsuarios;

/**
 * Servlet implementation class IngresarUsuarioCtrl
 */
@WebServlet("/adm/IngresarUsuarioCtrl")
public class IngresarUsuarioCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IngresarUsuarioCtrl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		GestorUsuarios usuarioService = new GestorUsuarios();
		Usuario usuario;
		
		HttpSession my=null;
		
		
		
		
		
		
		
		
		try{
			usuario = usuarioService.ingresarUsuario(username, password);
			
			
			
			request.setAttribute("Usuario", usuario.getUsername());
			
			/*usuario = new Usuario();
			usuario.setUsername(username);*/
			my=request.getSession();
			my.setAttribute("username", usuario);
			
/*			request.setAttribute("username", username);*/
			RequestDispatcher rc = request.getServletContext().getRequestDispatcher("/adm/index.jsp");
			rc.forward(request, response);
		}catch(Exception e){
			request.setAttribute("Resultado", "Usuario o contrasenia incorrecta");
			RequestDispatcher rc = request.getServletContext().getRequestDispatcher("/adm/ingresarUsuario.jsp");
			rc.forward(request, response);
		}
	}

}
