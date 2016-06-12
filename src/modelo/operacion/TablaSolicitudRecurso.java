package modelo.operacion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import modelo.datos.DatosBdD;
import modelo.datos.DatosRecurso;
import modelo.datos.DatosSolicitudRecurso;

public class TablaSolicitudRecurso extends Tabla {

	public TablaSolicitudRecurso() throws SQLException {
		super("SolicitudRecurso");
	}

	@Override
	public boolean insertar(DatosBdD d) throws SQLException {
		boolean ret = false;
		DatosSolicitudRecurso dsr = (DatosSolicitudRecurso) d;
		String sqlInsercion = "insert into " + getNombreTabla() + " (RecursoSolicitado, Comentario, Puntos) " +
								"VALUES (?, ?, ?);";
		PreparedStatement pst = op.getPreparedStatement(sqlInsercion);
		pst.setString(1, dsr.getRecursoSolicitado());
		pst.setString(2, dsr.getComentario());
		pst.setInt(3, dsr.getPuntos());
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
