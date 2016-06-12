package modelo.operacion;

import java.sql.*;

public class Operador {
	
	private Connection con;
	private String cadConexionMySQL;
	
	public Operador() {
		cadConexionMySQL = "jdbc:mysql://localhost/debint?user=root&password=1234";
	}
	
	public void conectar() throws SQLException {
		con = DriverManager.getConnection(cadConexionMySQL);
	}
	
	public ResultSet ejecutarConsulta(String consultaSQL) {
		ResultSet ret = null;
		try {
			Statement cmd = con.createStatement();
			ret = cmd.executeQuery(consultaSQL);
		} catch (Exception e){}
		return ret;
	}

	public Boolean ejecutarInstruccion(String instruccionSQL) {
		Boolean ret = true;
		try {
			Statement cmd = con.createStatement();
		    cmd.executeUpdate(instruccionSQL);
		} catch (Exception e) {
			ret = false;
		}
		return ret;
	}
	
	public PreparedStatement getPreparedStatement(String sql) {
		PreparedStatement ret = null;
		try {
			ret = con.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}
}

/*try {
Class.forName("com.mysql.jdbc.Driver");
} catch (ClassNotFoundException e) {}*/