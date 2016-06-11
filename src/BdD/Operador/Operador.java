package BdD.Operador;

import java.sql.*;

public class Operador {
	
	private Connection con;
	
	public Operador() {
		try {
		    Class.forName("com.mysql.jdbc.Driver").newInstance();
		    con = DriverManager.getConnection("jdbc:mysql://localhost/debint?user=root&password=1234");
		    System.out.println("Registro exitoso");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
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
}
