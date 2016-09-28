package potpourri;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public class JdbcTools {
	private String driver;
	private String login;
	private String password;
	private String url;

	private Connection connection;

	public String getDriver() {
		return driver;
	}

	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}

	public String getUrl() {
		return url;
	}

	public Connection getConnecion() {
		return this.connection;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void close() throws SQLException {
		if (connection != null) {
			connection.close();
		}
	}

	public void init() throws Exception {
		loadDriver();
		connection = createConnection();
	}

	public int executeUpdate(String query) {
		int result = -1;
		try {
			init();
			Statement statement = connection.createStatement();
			result = statement.executeUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public int executeUpdate(Object... parameters) throws SQLException { 
		int result = -1;
		try {
			init();
			PreparedStatement statement = connection.prepareStatement(
					"INSERT INTO test VALUES (?,?,?);");
			for (int i=0 ; i<3 ; i++) {
				statement.setObject(i+1, parameters[i]);
			}
			result = statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public int executeUpdateBis(Object... parameters) throws SQLException { 
		int result = -1;
		try (Connection connection = createConnection()) {
			loadDriver();
			PreparedStatement statement = connection.prepareStatement(
					"INSERT INTO test VALUES (?,?,?);");
			for (int i=0 ; i<3 ; i++) {
				statement.setObject(i+1, parameters[i]);
			}
			result = statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return result;
	}
	
	private void loadDriver() throws ClassNotFoundException {
		Class.forName(driver);
	}

	private Connection createConnection() throws SQLException {
		Connection conn = DriverManager.getConnection(url, login, password);
		return conn;
	}
}
