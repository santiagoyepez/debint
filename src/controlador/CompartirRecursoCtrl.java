package controlador;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.*;
import modelo.datos.DatosRecurso;
import modelo.operacion.TablaRecurso;

@WebServlet("/CompartirRecursoCtrl")
public class CompartirRecursoCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CompartirRecursoCtrl() {
        super();
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String respuesta = "Error";
		String titulo = request.getParameter("titulo");
		String descripcion = request.getParameter("descripcion");
		
		DatosRecurso dr = new DatosRecurso();
		dr.setIdUsuario(1);
		dr.setIdCategoria(1);
		dr.setTitulo(titulo);
		dr.setDescripcion(descripcion);
		dr.setVisible(true);
		
		try {
			TablaRecurso tr = new TablaRecurso();
			if (tr.insertar(dr)) respuesta = "Correcto";
		} catch (SQLException e) {
			respuesta = e.toString();
		}
		
		request.setAttribute("ret", respuesta);   
		RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/vistas/recurso/compartirRecurso.jsp");
		rd.forward(request, response);
	}
}
