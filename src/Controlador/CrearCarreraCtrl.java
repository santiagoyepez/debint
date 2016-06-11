package Controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BdD.Datos.CamposCarrera;
import BdD.Operador.TablaCarrera;


@WebServlet("/CrearCarreraCtrl")
public class CrearCarreraCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CrearCarreraCtrl() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String resultado = "";
		String nombre = request.getParameter("txtNombre");	
		CamposCarrera carrera = new CamposCarrera();
		carrera.getCarrera().setValor(nombre);
		TablaCarrera t = new TablaCarrera();		
		try {
			
			Boolean r = t.insertar(carrera);
		  	resultado="Creacion Exitosa";
		}catch(Exception e){
			resultado="Error en la creación " + e.getMessage();
			e.printStackTrace();
		}
		request.setAttribute("ret", resultado);  
		RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/index.jsp");
		
		rd.forward(request, response);
	}
}
