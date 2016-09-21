package business.impl.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import business.impl.BusinessNoLog;
import org.junit.Assert;

public class BusinessNoLogTest {
	private BusinessNoLog business;
	
	@Before
	public void setup(){
		 business = new BusinessNoLog();
	}
	
	@After
	public void tearDown(){
		
	}
	
	@Test
	public void testDoAddition() {
		Assert.assertEquals(0, business.doAddition(-1, 1));
		Assert.assertEquals(0, business.doAddition(0, 0));
		Assert.assertEquals(8, business.doAddition(5, 3));
		Assert.assertEquals(-5, business.doAddition(-1, -4));
	}

	@Test
	public void testDoLogin() {
		Assert.assertEquals(true, business.doLogin("coucou", "coucou"));
		Assert.assertEquals(false, business.doLogin("coucou", "hello"));
		Assert.assertEquals(false, business.doLogin("", "hello"));
	}

}
