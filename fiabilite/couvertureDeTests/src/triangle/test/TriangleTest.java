package triangle.test;

import org.junit.Test;
import static org.junit.Assert.*;

import triangle.Triangle;

public class TriangleTest {
	private Triangle triangle1;
	private Triangle triangle2;
	
	@Test(expected=IllegalArgumentException.class)
	public void testTriangle () {
		triangle1 = new Triangle(1,2,3);
		assertNotNull(triangle1);
		triangle2 = new Triangle(0,1,2);
	}
}
