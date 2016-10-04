package test;
/*
 * @author PR
 * @version 1
 * Unit tests for the StringArray class (First set)
 */
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import strarray.StringArray;


public class StringArrayTest {
	private static String[] slist1={
		"a","b","ccc","ccd","d","e","f","g"
	};
	private static String[] slist2={
		"ab","ccd","ccc","g","f","e","d"
	};
	private static String[] slist3={
			"ab","c","ab"
		};

	private StringArray array1;
	private StringArray array2;
	private StringArray array3;

	@Before
	public void setUp() throws Exception {		
        //nothing to do for this first set
	}
	
	@Test
	public void testStringArray() {
		array1=new StringArray(slist1);
		array2=new StringArray(slist2);	
		array3 = new StringArray(slist3);
		assertEquals(8,array1.size());		
		assertEquals(7,array2.size());
		assertEquals(2,array3.size());	
	}

	@Test
	public void test1IndexOf() {
		array2=new StringArray(slist2);
		assertEquals(-1,array2.IndexOf("ee"));
	}
	
	@Test
	public void test2IndexOf() {
		array2=new StringArray(slist2);
		assertEquals(3,array2.IndexOf("d"));
	}
	
	@Test
	public void testGetString() {
		array1 = new StringArray(slist1);
		assertEquals("a",array1.getString(0));
	}	
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void testGetStringError() {
		array1 = new StringArray(slist1);
		assertEquals("a",array1.getString(-1));
	}
	
	@Test
	public void testEachElement() {
		array1 = new StringArray(slist1);
		for (int i=0 ; i<slist1.length ; i++) {
			assertEquals(slist1[i], array1.getString(i));
		}
	}
}
