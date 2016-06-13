package controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Periodo;
import modelo.operacion.TablaPeriodo;

/**
 * Servlet implementation class periodoEliminarPeriodo
 */
@WebServlet("/periodoEliminarPeriodo")
public class periodoEliminarPeriodo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public periodoEliminarPeriodo() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idRecibido = request.getParameter("id");
		
		TablaPeriodo tp = new TablaPeriodo();
		try{
			tp.eliminarPeriodo(Integer.parseInt(idRecibido));
			request.setAttribute("respuesta", "Eliminado correctamente"); 
		}catch(Exception e){
			request.setAttribute("respuesta", "Error "+e.getMessage().toString()); 
		}
		
		RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/periodoBuscarPeriodos");
		rd.forward(request, response); 
		
		//Redirigo a la pantalla para mostrar la respuesta
		
	}

}
