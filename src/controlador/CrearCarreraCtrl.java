package controlador;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.datos.DatosCarrera;
import modelo.operacion.TablaCarrera;

@WebServlet("/CrearCarreraCtrl")
public class CrearCarreraCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CrearCarreraCtrl() {
        super();
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String respuesta = "Error";
		String nombreCarrera = request.getParameter("nombreCarrera");
		DatosCarrera dc = new DatosCarrera();
		dc.setCarrera(nombreCarrera);
		try {
			TablaCarrera tc = new TablaCarrera();
			if (tc.insertar(dc)) respuesta = "Correcto";
		} catch (SQLException e) {
			respuesta = e.toString();
		}
		request.setAttribute("retCreacionCarrera", respuesta);   
		RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/vistas/panelAdmin/panelAdmin.jsp");
		rd.forward(request, response);
	}

}
