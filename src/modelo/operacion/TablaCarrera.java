package modelo.operacion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.datos.DatosBdD;
import modelo.datos.DatosCarrera;

public class TablaCarrera extends Tabla {

	public TablaCarrera() throws SQLException {
		super("Carrera");
	}

	@Override
	public boolean insertar(DatosBdD d) throws SQLException {
		boolean ret = false;
		DatosCarrera dc = (DatosCarrera) d;
		String sqlInsercion = "insert into " + getNombreTabla() + " (Carrera) VALUES (?);";		
		PreparedStatement pst = op.getPreparedStatement(sqlInsercion);
		pst.setString(1, dc.getCarrera());
		ret = (pst.executeUpdate() != 0);	
		return ret;
	}

	@Override
	public boolean eliminar(DatosBdD d) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean editar(DatosBdD d) {
		// TODO Auto-generated method stub
		return false;
	}

}
