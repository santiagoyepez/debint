package controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Periodo;
import modelo.operacion.TablaPeriodo;

@WebServlet("/periodoAgregarPeriodo")
public class periodoAgregarPeriodo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public periodoAgregarPeriodo() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String anoRecibido = request.getParameter("ano");
		String parteRecibida = request.getParameter("parte");
		
		TablaPeriodo tp = new TablaPeriodo();
		
		Periodo periodoCreacion = new Periodo();
		periodoCreacion.setAño(Integer.parseInt(anoRecibido));
		periodoCreacion.setParte(parteRecibida);
		
		try{
			tp.agregarPeriodo(periodoCreacion);
			request.setAttribute("respuesta", "Periodo agregado correctamente"); 
		}catch(Exception e){
			request.setAttribute("respuesta", "Error "+e.getMessage().toString()); 
		}
		
		RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/periodoBuscarPeriodos");
		rd.forward(request, response); 
		
		
	}

}
