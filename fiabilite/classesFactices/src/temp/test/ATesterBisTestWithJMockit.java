package temp.test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import mockit.Expectations;
import mockit.Mocked;
import mockit.Verifications;
import model.IConversion;
import temp.ATesterBis;


public class ATesterBisTestWithJMockit {
	private ATesterBis aTester;
	@Mocked
	private IConversion conversion;

	@Test
	public void testConversionC2F() {
		new Expectations() {{
			conversion.convC2F(0);result=32;
			conversion.convC2F(100);result=212;
			conversion.convC2F(37);result=98.6;
			conversion.convC2F(-40);result=-40;
			times=1;
		}};
		
		aTester = new ATesterBis(conversion);
		assertEquals(32,aTester.convertit(0, "C2F"),0.001);
		assertEquals(212,aTester.convertit(100, "C2F"),0.001);
		assertEquals(98.6,aTester.convertit(37, "C2F"),0.001);
		assertEquals(-40,aTester.convertit(-40, "C2F"),0.001);
		
		new Verifications() {{
			conversion.convF2C(anyDouble);times=0;
		}};
	}
	
	@Test
	public void testConversionF2C() {
		new Expectations() {{
			conversion.convF2C(32);result=0;
			conversion.convF2C(212);result=100;
			conversion.convF2C(98.6);result=37;
			conversion.convF2C(-40);result=-40;
			times=1;
		}};		
		
		aTester = new ATesterBis(conversion);
		assertEquals(0,aTester.convertit(32, "F2C"),0.001);
		assertEquals(100,aTester.convertit(212, "F2C"),0.001);
		assertEquals(37,aTester.convertit(98.6, "F2C"),0.001);
		assertEquals(-40,aTester.convertit(-40, "F2C"),0.001);
	
		new Verifications() {{
			conversion.convC2F(anyDouble);times=0;
		}};
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConversionIllegalArgument() {
		aTester = new ATesterBis(conversion);
		aTester.convertit(123.4, "illlegal argument");
	}
}
