package controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.datos.DatosBdD;
import modelo.operacion.TablaSolicitudRecurso;

@WebServlet("/ListarSolicitudesCtrl")
public class ListarSolicitudesCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ListarSolicitudesCtrl() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<DatosBdD> listaSolicitudes = null;		
		try {
			listaSolicitudes = new TablaSolicitudRecurso().seleccionarTodo();
		} catch (SQLException e) {}
		if (listaSolicitudes != null) if (listaSolicitudes.size() <= 0) listaSolicitudes = null;
		request.setAttribute("listaSolicitudes", listaSolicitudes);
		RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/vistas/generales/todasSolicitudes.jsp");
		rd.forward(request, response);	
	}
}
