package triangle.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import triangle.Triangle;

public class TriangleTest {
	@Rule
	public final ExpectedException exception = ExpectedException.none();
	
	
	@SuppressWarnings("unused")
	@Test
	//A séparer en plusieus tests
	public void testTriangle () {
		Triangle t1 = new Triangle(12,13,14);
		assertNotNull(t1);
		exception.expect(IllegalArgumentException.class);
		Triangle t2 = new Triangle(0,1,2);
		exception.expect(IllegalStateException.class);
		Triangle t3 = new Triangle(4,5,9);
	}
	
	@Test
	public void testType () {
		Triangle acutangleScalene = new Triangle(12,13,14);
		Triangle obtusangleScalene = new Triangle(3,5,7);
		Triangle rectangleScalene = new Triangle(5,10,Math.sqrt(125));
		Triangle acutangleIsocele = new Triangle(5,5,3);
		Triangle obtusangleIsocele = new Triangle(4,4,7);
		Triangle rectangleIsocele = new Triangle(4,4,Math.sqrt(32));
		Triangle equilateral = new Triangle(3,3,3);
		
		
		assertEquals(0, acutangleScalene.type());
		assertEquals(1, obtusangleScalene.type());
		assertEquals(2, rectangleScalene.type());
		assertEquals(3, acutangleIsocele.type());
		assertEquals(4, obtusangleIsocele.type());
		assertEquals(5, rectangleIsocele.type());
		assertEquals(6, equilateral.type());
	}
}
