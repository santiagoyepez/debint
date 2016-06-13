package modelo.operacion;

import java.sql.*;
import java.util.ArrayList;

import modelo.datos.DatosBdD;
import modelo.datos.DatosCarrera;
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
		ArrayList<DatosBdD> ret = new ArrayList<>();
		ResultSet rs = op.ejecutarConsulta("SELECT * FROM " + nombreTabla + ";");
		try {
			while (rs.next()) {
				DatosRecurso dcTemp = new DatosRecurso();
				dcTemp.setDescripcion(rs.getString("Descripcion"));
				dcTemp.setIdCategoria(rs.getInt("IdCategoria"));
				dcTemp.setIdRecurso(rs.getInt("IdRecurso"));
				//dcTemp.setIdSolicitud(rs.getInt("IdSolicitud"));
				dcTemp.setIdUsuario(rs.getInt("IdUsuario"));
				dcTemp.setNombreArchivo(rs.getString("NombreArchivo"));
				dcTemp.setTitulo(rs.getString("Titulo"));
				ret.add(dcTemp);
			}
		} catch (SQLException e) {
			ret = null;
		}
		return ret;
	}
}
