package controlador;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.datos.DatosRecurso;
import modelo.datos.DatosSolicitudRecurso;
import modelo.operacion.TablaRecurso;
import modelo.operacion.TablaSolicitudRecurso;

@WebServlet("/SolicitarRecursoCtrl")
public class SolicitarRecursoCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SolicitarRecursoCtrl() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String respuesta = "Error";
		String recursoSolicitado = request.getParameter("recursoSolicitado");
		String comentario = request.getParameter("comentario");
		
		DatosSolicitudRecurso dsr = new DatosSolicitudRecurso();
		dsr.setComentario(comentario);
		dsr.setRecursoSolicitado(recursoSolicitado);
		dsr.setPuntos(1);
		
		try {
			TablaSolicitudRecurso tsr = new TablaSolicitudRecurso();
			if (tsr.insertar(dsr)) respuesta = "Correcto";
		} catch (SQLException e) {
			respuesta = e.toString();
		}
		
		/*request.setAttribute("ret", respuesta);   
		RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/vistas/recurso/compartirRecurso.jsp");
		rd.forward(request, response);*/
	}

}
