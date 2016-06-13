package modelo.operacion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.datos.DatosBdD;
import modelo.datos.DatosCarrera;
import modelo.datos.DatosMateria;

public class TablaMateria extends Tabla{

	public TablaMateria() throws SQLException {
		super("Materia");
	}

	@Override
	public boolean insertar(DatosBdD d) throws SQLException {
		boolean ret = false;
		DatosMateria dm = (DatosMateria) d;
		String sqlInsercion = "insert into " + getNombreTabla() + " (idCarrera, Materia) VALUES (?, ?);";		
		PreparedStatement pst = op.getPreparedStatement(sqlInsercion);
		pst.setInt(1, dm.getIdCarrera());
		pst.setString(2, dm.getMateria());
		ret = (pst.executeUpdate() != 0);	
		return ret;
	}

	@Override
	public boolean eliminar(DatosBdD d) {
		return false;
	}

	@Override
	public boolean editar(DatosBdD d) {
		return false;
	}

	@Override
	public ResultSet seleccionar(DatosBdD d) {
		return null;
	}

	@Override
	public ArrayList<DatosBdD> seleccionarTodo() {
		return null;
	}
	
	public ArrayList<DatosMateria> seleccionarMateriasCarrera(int idCarrera) {
		ArrayList<DatosMateria> ret = new ArrayList<>();
		ResultSet rs = op.ejecutarConsulta("SELECT * FROM " + nombreTabla + " WHERE idCarrera = " + idCarrera + ";");
		try {
			while (rs.next()) {
				DatosMateria dcTemp = new DatosMateria();
				dcTemp.setIdMateria(rs.getInt("idMateria"));
				dcTemp.setIdCarrera(rs.getInt("idCarrera"));
				dcTemp.setMateria(rs.getString("Materia"));
				ret.add(dcTemp);
			}
		} catch (SQLException e) {
			ret = null;
		}
		return ret;
	}

}
