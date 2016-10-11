package temp.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import temp.ATesterBis;
import temp.test.mock.MockConversionBis;

/**
 * Test de ATesterBis qui utilise MockConversionBis
 * L'ensemble (ATesterBis,MockConversionBis,ATesterBisTest) se base
 * sur une interface plutôt que la classe concrète Conversion
 * ce qui lui permet d'être fonctionelle 
 * @author l21003949
 *
 */
public class ATesterBisTest {
	private static ATesterBis aTester;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		aTester = new ATesterBis(new MockConversionBis());
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testConvertit() {
		assertEquals(32,aTester.convertit(0, "C2F"),0.001);
		assertEquals(212,aTester.convertit(100, "C2F"),0.001);
		assertEquals(98.6,aTester.convertit(37, "C2F"),0.001);
		assertEquals(-40,aTester.convertit(-40, "C2F"),0.001);
		
		assertEquals(0,aTester.convertit(32, "F2C"),0.001);
		assertEquals(100,aTester.convertit(212, "F2C"),0.001);
		assertEquals(37,aTester.convertit(98.6, "F2C"),0.001);
		assertEquals(-40,aTester.convertit(-40, "F2C"),0.001);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testConvertitIllegalArgument() {
		aTester.convertit(123.4, "illegalArgument");
	}

}
