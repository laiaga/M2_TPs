package essai;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;

public class EssaiTest {

	private Essai essai1;
	private Essai essai2;
	
	@AfterClass
	public static void classTearDown() throws Exception {
		System.out.println("class tear down");
	}
	
	@BeforeClass
	public static void classSetUp() throws Exception {
		System.out.println("class set up");
	}
	
	@After
	public void tearDown() throws Exception {
		System.out.println("tear down");
	}
	
	@Before
	public void setUp() throws Exception {
		essai1 = new Essai(0);
		essai2 = new Essai(1);
		System.out.println("set up");
	}

	@Test
	public void testSetVal() {
		essai1.setVal(1);
		Assert.assertEquals(1, essai1.getVal());
		essai2.setVal(2);
		Assert.assertEquals(2, essai2.getVal());
	}

	@Test
	public void testGetVal() {
		Assert.assertEquals(0, essai1.getVal());
		Assert.assertEquals(1, essai2.getVal());
	}

	@Test
	public void testEssai() {
		Assert.assertNotNull(essai1);
	}
	
	@Test
	public void testQuiEchoue(){
		Assert.assertEquals(42, essai1.getVal());
	}

	@Test(expected=ArithmeticException.class)
	public void testInv() {
		essai1.inv();
	}
}
