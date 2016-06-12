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
import modelo.datos.DatosMateria;
import modelo.operacion.TablaMateria;

@WebServlet("/ListarMateriasCtrl")
public class ListarMateriasCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ListarMateriasCtrl() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<DatosMateria> listaMaterias = null;		
		int idCarrera = Integer.parseInt(request.getParameter("idCarrera"));
		try {
			listaMaterias = new TablaMateria().seleccionarMateriasCarrera(idCarrera);
		} catch (SQLException e) {}
		if (listaMaterias != null) if (listaMaterias.size() <= 0) listaMaterias = null;
		request.setAttribute("listaMaterias", listaMaterias);
		RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/vistas/panelAdmin/panelAdmin.jsp");
		rd.forward(request, response);	
	}

}
