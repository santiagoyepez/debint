package modelo.operacion;

import java.sql.ResultSet;
import java.sql.SQLException;

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
	
	public ResultSet seleccionarTodo() {
		return op.ejecutarConsulta("SELECT * FROM " + nombreTabla + ";");
	}
	
	public String getNombreTabla() {
		return nombreTabla;
	}
}