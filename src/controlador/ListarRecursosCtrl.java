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
import modelo.operacion.TablaCarrera;
import modelo.operacion.TablaRecurso;

@WebServlet("/ListarRecursosCtrl")
public class ListarRecursosCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ListarRecursosCtrl() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<DatosBdD> listaRecursos = null;		
		try {
			listaRecursos = new TablaRecurso().seleccionarTodo();
		} catch (SQLException e) {}
		if (listaRecursos != null) if (listaRecursos.size() <= 0) listaRecursos = null;
		request.setAttribute("listaRecursos", listaRecursos);
		RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/vistas/generales/todosRecursos.jsp");
		rd.forward(request, response);	
	}

}
