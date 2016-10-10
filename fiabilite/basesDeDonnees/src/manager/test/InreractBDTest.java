package manager.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import manager.InteractBD;

public class InreractBDTest {
	InteractBD idb;
		
	@Before
	public void setUp() throws Exception {
		idb = new InteractBD();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testConnect() throws ClassNotFoundException, SQLException {
		assertFalse(idb.isConnected());
		idb.connect();
		assertTrue(idb.isConnected());
	}
	
	@Test
	public void testDisconnect() throws ClassNotFoundException, SQLException {
		idb.connect();
		assertTrue(idb.isConnected());
		idb.disconnect();
		assertFalse(idb.isConnected());
	}
	
	@Test
	public void testIsConnected() throws ClassNotFoundException, SQLException {
		idb.connect();
		assertEquals(idb.getConnection().isValid(5000),idb.isConnected());
		idb.disconnect();
		assertEquals(idb.getConnection().isValid(5000),idb.isConnected());
	}

}
