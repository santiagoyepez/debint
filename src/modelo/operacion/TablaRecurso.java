package modelo.operacion;

import java.sql.*;

import modelo.datos.DatosBdD;
import modelo.datos.DatosRecurso;

public class TablaRecurso extends Tabla{

	public TablaRecurso() throws SQLException {
		super("recurso");
	}

	@Override
	public boolean insertar(DatosBdD d) throws SQLException {
		boolean ret = false;
		DatosRecurso dr = (DatosRecurso) d;
		String sqlInsercion = "insert into " + getNombreTabla() + " (idUsuario, idCategoria, Titulo, Descripcion, Visible, idSolicitud) " +
								"VALUES (?, ?, ?, ?, ?, ?);";
		PreparedStatement pst = op.getPreparedStatement(sqlInsercion);
		pst.setInt(1, dr.getIdUsuario());
		pst.setInt(2, dr.getIdCategoria());
		pst.setString(3, dr.getTitulo());
		pst.setString(4, dr.getDescripcion());
		pst.setBoolean(5, dr.getVisible());
		if (dr.getIdSolicitud() == 0) {
			pst.setNull(6, Types.NULL);
		} else {
			pst.setInt(6,  dr.getIdSolicitud());
		}
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
	public ResultSet seleccionarTodo(DatosBdD d) {
		return null;
	}

	

}
