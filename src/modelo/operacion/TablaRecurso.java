package modelo.operacion;

import java.sql.*;
import java.util.ArrayList;

import modelo.datos.DatosBdD;
import modelo.datos.DatosRecurso;

public class TablaRecurso extends Tabla{

	public TablaRecurso() throws SQLException {
		super("Recurso");
	}

	@Override
	public boolean insertar(DatosBdD d) throws SQLException {
		boolean ret = false;
		DatosRecurso dr = (DatosRecurso) d;
		String sqlInsercion = "insert into " + getNombreTabla() + " (idUsuario, idCategoria, Titulo, Descripcion, Visible, NombreArchivo, idSolicitud) " +
								"VALUES (?, ?, ?, ?, ?, ?, ?);";
		PreparedStatement pst = op.getPreparedStatement(sqlInsercion);
		pst.setInt(1, dr.getIdUsuario());
		pst.setInt(2, dr.getIdCategoria());
		pst.setString(3, dr.getTitulo());
		pst.setString(4, dr.getDescripcion());
		pst.setBoolean(5, dr.getVisible());
		pst.setString(6, dr.getNombreArchivo());
		if (dr.getIdSolicitud() == 0) {
			pst.setNull(7, Types.NULL);
		} else {
			pst.setInt(7, dr.getIdSolicitud());
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
	public ResultSet seleccionar(DatosBdD d) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<DatosBdD> seleccionarTodo() {
		// TODO Auto-generated method stub
		return null;
	}
}
