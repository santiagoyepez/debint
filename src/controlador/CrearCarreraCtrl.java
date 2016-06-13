package controlador;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
		String retCreacionCarrera = "Error";
		String nombreCarrera = request.getParameter("nombreCarrera");
		DatosCarrera dc = new DatosCarrera();
		dc.setCarrera(nombreCarrera);
		try {
			TablaCarrera tc = new TablaCarrera();
			if (tc.insertar(dc)) retCreacionCarrera = "Correcto";
		} catch (SQLException e) {
			retCreacionCarrera = e.toString();
		}
		request.setAttribute("retCreacionCarrera", retCreacionCarrera);  
		RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/vistas/panelAdmin/panelAdmin.jsp");
		rd.forward(request, response);
	}

}
