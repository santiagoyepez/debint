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
 * Servlet implementation class periodoBuscarPeriodos
 */
@WebServlet("/periodoBuscarPeriodos")
public class periodoBuscarPeriodos extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public periodoBuscarPeriodos() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TablaPeriodo tp = new TablaPeriodo();
		try{
			List<Periodo> periodosRecibidos = tp.buscarPeriodos();
			request.setAttribute("periodosEncontrados", periodosRecibidos);
		}catch(Exception e){
			request.setAttribute("respuesta", "Error "+e.getMessage().toString()); 
		}

		
		if(request.getParameter("respuesta")!=null){
			request.setAttribute("respuesta", request.getParameter("respuesta"));
		}
		RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/vistas/periodo.jsp");
		rd.forward(request, response); 
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}


}
