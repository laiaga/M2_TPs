package item.tests;

import org.junit.After;
import org.junit.Test;
import org.junit.Before;
import org.junit.Assert;
import item.Item;

public class ItemTest {
	private Item cheapItem;
	private Item cheapItemBis;
	private Item expensiveItem;

	@Before
	public void setUp() throws Exception {
		cheapItem = new Item("cheap", 4.2f);
		cheapItemBis = new Item("cheap", 4.2f);
		expensiveItem = new Item("expensive", 6.2f);
	}

	@After
	public void tearDown() throws Exception {
		cheapItem = null;
		cheapItemBis = null;
		expensiveItem = null;
	}

	@Test
	public void testGetPrice() {
		Assert.assertEquals(4.2f, cheapItem.getPrice(),0.001);
	}

	@Test
	public void testGreaterThanPrice() {
		Assert.assertEquals(true, expensiveItem.greaterThanPrice(cheapItem));
		Assert.assertEquals(false, expensiveItem.greaterThanPrice(expensiveItem));
		Assert.assertEquals(false, cheapItem.greaterThanPrice(expensiveItem));
	}

	@Test
	public void testLessThanPrice() {
		Assert.assertEquals(false, expensiveItem.lessThanPrice(cheapItem));
		Assert.assertEquals(false, expensiveItem.lessThanPrice(expensiveItem));
		Assert.assertEquals(true, cheapItem.lessThanPrice(expensiveItem));
	}
	
	@Test
	public void testLessEqualPrice() {
		Assert.assertEquals(false, expensiveItem.lessEqualPrice(cheapItem));
		Assert.assertEquals(true, expensiveItem.lessEqualPrice(expensiveItem));
		Assert.assertEquals(true, cheapItem.lessEqualPrice(expensiveItem));
	}

	@Test
	public void testIsSameArticle() {
		Assert.assertEquals(true, cheapItem.isSameArticle(cheapItemBis));
		Assert.assertEquals(false, cheapItem.isSameArticle(expensiveItem));
	}

}
