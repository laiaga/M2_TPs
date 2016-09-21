package log.impl.test;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import log.impl.StdoutLogger;

public class StdoutLoggerTest {
	private StdoutLogger logger;
	
	@Before
	public void setup(){
		 logger = new StdoutLogger();
	}
	
	@After
	public void tearDown(){
		
	}
	@Test
	public void testLogString() {
		fail("Not yet implemented");
	}

	@Test
	public void testLogStringString() {
		fail("Not yet implemented");
	}

}
