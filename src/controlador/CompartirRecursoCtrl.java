package controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import modelo.*;
import modelo.datos.DatosRecurso;
import modelo.operacion.TablaRecurso;

@WebServlet("/CompartirRecursoCtrl")
@MultipartConfig(location="D:/Proyectos/eclipse/debint/WebContent/subidas")//location="D:/debint"
public class CompartirRecursoCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String nombreArchivo;
    public CompartirRecursoCtrl() {
        super();
    }
    
    protected void subirArchivo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        nombreArchivo = null;
    	response.setContentType("text/html;charset=UTF-8");
        Collection<Part> parts = request.getParts();
        for(Part part : parts) {
        	String nombre = getFileName(part);
        	if (nombre != null) {
        		part.write(nombre);
        		nombreArchivo = nombre;
        	}
        		
        }
    }
    
    public String getFileName(Part part) {
        String contentHeader = part.getHeader("content-disposition");
        String[] subHeaders = contentHeader.split(";");
        for(String current : subHeaders) {
            if(current.trim().startsWith("filename")) {
                int pos = current.indexOf('=');
                String fileName = current.substring(pos + 1);
                return fileName.replace("\"", "");
            }
        }
        return null;
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		subirArchivo(request, response);
		
		String respuesta = "Error";
		String titulo = request.getParameter("titulo");
		String descripcion = request.getParameter("descripcion");
		
		DatosRecurso dr = new DatosRecurso();
		dr.setIdUsuario(1);
		dr.setIdCategoria(1);
		dr.setTitulo(titulo);
		dr.setDescripcion(descripcion);
		dr.setVisible(true);
		dr.setNombreArchivo(nombreArchivo);
		
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
