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
import ec.edu.epn.modelo.Request;

/**
 * Servlet implementation class CrearPeticionCtrl
 */
@WebServlet("/adm/CrearPeticionCtrl")
public class CrearPeticionCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrearPeticionCtrl() {
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
		//Preparamos informacion
			
		String asunto = request.getParameter("txtAsunto");
		String id = request.getParameter("txtid");
				Integer a = Integer.parseInt(id);
				
		
		
				Request requesto = new Request();
				Usuario usuario = new Usuario();
				
				usuario.setId(a);
				
				
				
				requesto.setTxtRequest(asunto);
				requesto.setUsuario(usuario);
				
				
				
				//Llamar al modelo
				GestorUsuarios gu = new GestorUsuarios();
				
				String resultado = "";
				
				try{
					gu.crearRequest(requesto);
					
					resultado = "Exito";
				}catch(Exception e){
					resultado = "Error" + e.getMessage();
					e.printStackTrace();
				}
				
				//Publicar los datos dados por el modelo
				request.setAttribute("RESULTADO", resultado);
				
				//Redireccionar a la vista
				RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/adm/crearRequest.jsp");
				
				rd.forward(request, response);

	}

}
