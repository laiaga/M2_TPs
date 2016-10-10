package manager;

import java.sql.*;

public class InteractBD {
	private String url = "jdbc:mysql://dbs-perso.luminy.univmed.fr/l21003949?useSSL=false";
	private String login = "l21003949";
	private String password = "E8Rp5a";
	private String driver = "com.mysql.jdbc.Driver";
	private Connection connection;

	public Connection getConnection () { return connection; }
	
	public void connect () throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		connection = DriverManager.getConnection(url, login, password);
	}
	
	public void disconnect () throws SQLException {
		connection.close();
	}
	
	public boolean isConnected () throws SQLException {
		if (connection == null) {
			return false;
		} else {
			return connection.isValid(5000);
		}
	}
	
}
