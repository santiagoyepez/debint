package controlador;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.datos.DatosMateria;
import modelo.operacion.TablaMateria;

@WebServlet("/CrearMateriaCtrl")
public class CrearMateriaCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CrearMateriaCtrl() {
        super();
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String retCreacionMateria = "Error";
		String materia = request.getParameter("nombreMateria");
		int idCarrera = Integer.parseInt(request.getParameter("idCarrera"));
		DatosMateria dm = new DatosMateria();
		dm.setIdCarrera(idCarrera);
		dm.setMateria(materia);
		try {
			TablaMateria tm = new TablaMateria();
			if (tm.insertar(dm)) retCreacionMateria = "Correcto";
		} catch (SQLException e) {
			retCreacionMateria = e.toString();
		}
		request.setAttribute("retCreacionMateria", retCreacionMateria);  
		RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/vistas/panelAdmin/panelAdmin.jsp");
		rd.forward(request, response);
	}

}
