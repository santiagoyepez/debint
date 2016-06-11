package BdD.Operador;

import java.sql.ResultSet;

import BdD.Datos.ConjuntoCampos;

public class TablaCarrera extends Tabla{

	public TablaCarrera() {
		super("Carrera");
	}

	@Override
	public Boolean insertar(ConjuntoCampos d) {
		//CamposCarrera dc = (CamposCarrera) d;
		return super.insertar(d);
	}

	@Override
	public Boolean eliminar(ConjuntoCampos d) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean editar(ConjuntoCampos d) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet seleccionarTodo(ConjuntoCampos d) {
		// TODO Auto-generated method stub
		return null;
	}

}
