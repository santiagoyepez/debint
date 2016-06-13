package modelo.operacion;

import java.sql.*;

public class Operador {
	
	private Connection con;
	private String cadConexionMySQL,cadConexionMySQLRemoto;
	
	public Operador() {
		cadConexionMySQL = "jdbc:mysql://localhost/debint?user=root&password=1234";
		cadConexionMySQLRemoto = "jdbc:mysql://199.168.189.114/integrae_appweb?user=integrae_userApp&password=AplicacionesWeb2016";
	}
	
	public void conectar() throws SQLException {
		con = DriverManager.getConnection(cadConexionMySQLRemoto);
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