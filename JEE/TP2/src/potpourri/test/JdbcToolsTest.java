package potpourri.test;


import java.sql.SQLException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import potpourri.JdbcTools;

public class JdbcToolsTest {
	private String url = "jdbc:mysql://dbs-perso.luminy.univmed.fr/l21003949";
	private String login = "l21003949";
	private String password = "E8Rp5a";
	private String driver = "com.mysql.jdbc.Driver";
	private JdbcTools tools;

	@Before
	public void setUp() throws Exception {
		tools = new JdbcTools();
		tools.setDriver(driver);
		tools.setUrl(url);
		tools.setLogin(login);
		tools.setPassword(password);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void initTest() throws Exception {
		tools.init();
		Assert.assertEquals(true, tools.getConnecion().isValid(0));
	}

	@Test(expected = SQLException.class)
	public void initTestSQLException() throws Exception {
		tools.setPassword("false_pwd");
		tools.init();
	}

	@Test(expected = ClassNotFoundException.class)
	public void initTestClassNotFoundException() throws Exception {
		tools.setDriver("false_driver");
		tools.init();
	}
	
	@Test
	public void closeTest() throws Exception {
		tools.init();
		Assert.assertEquals(false, tools.getConnecion().isClosed());
		tools.close();
		Assert.assertEquals(true, tools.getConnecion().isClosed());
	}
	
	@Test
	public void executeUpdateTest() throws SQLException {
		Assert.assertEquals(1,tools.executeUpdate("INSERT INTO test (nom,prenom) VALUES ('john', 'doe');"));
		Object[] parameters = {"martin","blanc",30};
		Assert.assertEquals(1,tools.executeUpdate(parameters));
		Object[] parametersBis = {"jean","valjean",42};
		Assert.assertEquals(1,tools.executeUpdateBis(parametersBis));
	}
}
