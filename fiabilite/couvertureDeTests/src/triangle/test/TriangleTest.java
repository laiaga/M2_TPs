package triangle.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import triangle.Triangle;

public class TriangleTest {
	@Rule
	public final ExpectedException exception = ExpectedException.none();

	@Test
	public void testTriangle() {
		Triangle t = new Triangle(12, 13, 14);
		assertNotNull(t);
	}

	@SuppressWarnings("unused")
	@Test
	public void testTriangleInvalidLength() {
		exception.expect(IllegalArgumentException.class);
		Triangle t = new Triangle(0, 1, 2);
	}

	@SuppressWarnings("unused")
	@Test
	public void testTriangleInvalidAngles() {
		exception.expect(IllegalStateException.class);
		Triangle t = new Triangle(4, 5, 9);
	}

	@Test
	public void testType() {
		Triangle acutangleScalene = new Triangle(12, 13, 14);
		Triangle obtusangleScalene = new Triangle(3, 5, 7);
		Triangle rectangleScalene = new Triangle(5, 10, Math.sqrt(125));
		Triangle acutangleIsocele = new Triangle(5, 5, 3);
		Triangle obtusangleIsocele = new Triangle(4, 4, 7);
		Triangle rectangleIsocele = new Triangle(4, 4, Math.sqrt(32));
		Triangle equilateral = new Triangle(3, 3, 3);

		assertEquals(0, acutangleScalene.type());
		assertEquals(1, obtusangleScalene.type());
		assertEquals(2, rectangleScalene.type());
		assertEquals(3, acutangleIsocele.type());
		assertEquals(4, obtusangleIsocele.type());
		assertEquals(5, rectangleIsocele.type());
		assertEquals(6, equilateral.type());
	}

	@Test
	public void testRead() {
		Charset charset = Charset.forName("UTF-8");
		Path path = FileSystems.getDefault().getPath("testRead");

		try {
			Files.deleteIfExists(path);
			Files.createFile(path);
			BufferedWriter writer = Files.newBufferedWriter(path, charset);

			writer.write("12" + "\n");
			writer.write("13" + "\n");
			writer.write("14" + "\n");

			writer.close();

			Triangle t = Triangle.read("testRead");
			assertNotNull(t);
			assertEquals(12, t.getA(), 0.001);
			assertEquals(13, t.getB(), 0.001);
			assertEquals(14, t.getC(), 0.001);

			Files.delete(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testReadFileNotExists() throws IOException {
		exception.expect(IOException.class);
		Triangle.read("not existing file");
	}

	@Test
	public void testReadInvalidValue() throws IOException {
		Charset charset = Charset.forName("UTF-8");
		Path path = FileSystems.getDefault().getPath("testReadInvalidValue");

		Files.deleteIfExists(path);
		Files.createFile(path);
		BufferedWriter writer = Files.newBufferedWriter(path, charset);

		writer.write("12" + "\n");
		writer.write("13" + "\n");
		writer.write("invalid" + "\n");

		writer.close();

		exception.expect(IOException.class);
		Triangle.read("testReadInvalidValue");
	}

	@Test
	public void testReadInvalidNumberOfValues() throws IOException {
		Charset charset = Charset.forName("UTF-8");
		Path path = FileSystems.getDefault().getPath("testReadInvalidNumberOfValues");

		Files.deleteIfExists(path);
		Files.createFile(path);
		BufferedWriter writer = Files.newBufferedWriter(path, charset);

		writer.write("12" + "\n");
		writer.write("13" + "\n");
		writer.write("14" + "\n");
		writer.write("15" + "\n");

		writer.close();

		exception.expect(IOException.class);
		Triangle.read("testReadInvalidNumberOfValues");
	}
	
	@Test
	public void testWrite() throws IOException {
		Triangle t1 = new Triangle(12,13,14);
		Triangle.write(t1, "testWrite");
		Path path = FileSystems.getDefault().getPath("testWrite");
		Assert.assertTrue(Files.exists(path));
		
		Triangle t2 = Triangle.read("testWrite");
		assertNotNull(t2);
		assertEquals(12, t2.getA(), 0.001);
		assertEquals(13, t2.getB(), 0.001);
		assertEquals(14, t2.getC(), 0.001);
	}
}
