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

@WebServlet("/ListarCarrerasCtrl")
public class ListarCarrerasCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ListarCarrerasCtrl() {
        super();
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<DatosCarrera> listaCarreras = new ArrayList<>();
		
		try {
			TablaCarrera tc = new TablaCarrera();
			ResultSet rs = tc.seleccionarTodo();
			while (rs.next()) {
				DatosCarrera dcTemp = new DatosCarrera();
				dcTemp.setCarrera(rs.getString("Carrera"));
				dcTemp.setIdCarrera(rs.getInt("IdCarrera"));
				listaCarreras.add(dcTemp);
			}
		} catch (SQLException e) {}

		if (listaCarreras.size() <= 0) listaCarreras = null;
		request.setAttribute("listaCarreras", listaCarreras);
		RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/vistas/panelAdmin/panelAdmin.jsp");
		rd.forward(request, response);	
	}

}
