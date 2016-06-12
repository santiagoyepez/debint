package modelo.operacion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.datos.*;

public abstract class Tabla {
	protected String nombreTabla;
	protected Operador op;
	
	protected Tabla(String nombreTabla) throws SQLException {
		this.nombreTabla = nombreTabla;
		op = new Operador();
		op.conectar();
	}
	
	public abstract boolean insertar(DatosBdD d) throws SQLException;
	
	public abstract boolean eliminar(DatosBdD d);
	
	public abstract boolean editar(DatosBdD d);
	
	public abstract ResultSet seleccionar(DatosBdD d);
	
	public abstract ArrayList<DatosBdD> seleccionarTodo();
	
	public String getNombreTabla() {
		return nombreTabla;
	}
}