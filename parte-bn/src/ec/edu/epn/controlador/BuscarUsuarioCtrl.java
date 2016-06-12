package ec.edu.epn.controlador;

import java.io.IOException;
import java.util.List;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.epn.modelo.Usuario;
import ec.edu.epn.modelo.servicios.GestorUsuarios;


@WebServlet("/adm/BuscarUsuarioCtrl")
public class BuscarUsuarioCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BuscarUsuarioCtrl() {
        super();
           }

	//Recibe Peticiones
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//Preparar la información
		String nombreBusqueda = request.getParameter("nombreBusqueda");
		
	//Llamar al modelo
		System.out.print("1");
		
		GestorUsuarios gu = new GestorUsuarios();
		List<Usuario> usuarios = null;
		usuarios = gu.buscarUsuarios(nombreBusqueda);
		
	//Publicar la información
		request.setAttribute("USUARIOS", usuarios);
		
	//Redireccionar a la vista
		System.out.print("2");
		
		RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/adm/administracion.jsp");
		
		rd.forward(request, response);
		
		System.out.print("3");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
