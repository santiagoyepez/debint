package BdD.Operador;

import java.sql.*;

import BdD.Datos.CampoTabla;
import BdD.Datos.ConjuntoCampos;

public abstract class Tabla {
	protected String nombreTabla;
	protected Operador op;
	
	protected Tabla(String nombreTabla) {
		this.nombreTabla = nombreTabla;
		op = new Operador();
	}
	
	public Boolean insertar(ConjuntoCampos d) {
		String campos = "", valores = "";
		for (int i = 0; i < d.getListaCampos().size(); i++) {
			CampoTabla ct = d.getListaCampos().get(i);
			if (ct.getValor() != null) {
				campos += ct.getNombreCampo();
				valores += ct.getValorInsercion();
				if (i < d.getListaCampos().size() - 1) {
					campos += ", ";
					valores += ", ";
				}
			}		
		}
		String SQL = "INSERT INTO " + nombreTabla + " (" + campos + ") VALUES (" + valores + ")";
		return op.ejecutarInstruccion(SQL);
	}
	
	public abstract Boolean eliminar(ConjuntoCampos d);
	
	public abstract Boolean editar(ConjuntoCampos d);
	
	public abstract ResultSet seleccionarTodo(ConjuntoCampos d);
	
	public String getNombreTabla() {
		return nombreTabla;
	}
}
