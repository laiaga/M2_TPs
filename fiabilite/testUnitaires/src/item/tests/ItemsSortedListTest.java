package item.tests;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import item.Item;
import item.IItemsSortedList;
import item.ItemsSortedList;
import item.ItemsSortedList2;
import item.ItemsSortedList3;
import item.ItemsSortedList4;
import item.ItemsSortedList5;

public class ItemsSortedListTest {
	private ArrayList<Item> itemList;
	private IItemsSortedList items;

	@Before
	public void setUp() throws Exception {
		itemList = new ArrayList<>();
		itemList.add(new Item("un", 1));
		itemList.add(new Item("deux", 2));
		itemList.add(new Item("trois", 3));
	}

	@Test
	public void testIsPresentArticle() {
		items = new ItemsSortedList(itemList);
		Assert.assertEquals(true, items.isPresentArticle(itemList.get(0)));
		Assert.assertEquals(true, items.isPresentArticle(new Item("trois",3)));
		Assert.assertEquals(false, items.isPresentArticle(new Item("deux",3)));
	}
	
	@Test
	public void testIsPresentArticle2() {
		items = new ItemsSortedList2(itemList);
		Assert.assertEquals(true, items.isPresentArticle(itemList.get(0)));
		Assert.assertEquals(true, items.isPresentArticle(new Item("trois",3)));
		Assert.assertEquals(false, items.isPresentArticle(new Item("deux",3)));
	}
	
	@Test
	public void testIsPresentArticle3() {
		items = new ItemsSortedList3(itemList);
		Assert.assertEquals(true, items.isPresentArticle(itemList.get(0)));
		Assert.assertEquals(true, items.isPresentArticle(new Item("trois",3)));
		Assert.assertEquals(false, items.isPresentArticle(new Item("deux",3)));
	}
	
	@Test(timeout=1000)
	public void testIsPresentArticle4() {
		items = new ItemsSortedList4(itemList);
		Assert.assertEquals(true, items.isPresentArticle(itemList.get(0)));
		Assert.assertEquals(true, items.isPresentArticle(new Item("trois",3)));
		Assert.assertEquals(false, items.isPresentArticle(new Item("deux",3)));
	}
	
	@Test(timeout=1000)
	public void testIsPresentArticle5() {
		items = new ItemsSortedList5(itemList);
		Assert.assertEquals(true, items.isPresentArticle(itemList.get(0)));
		Assert.assertEquals(true, items.isPresentArticle(new Item("trois",3)));
		Assert.assertEquals(false, items.isPresentArticle(new Item("deux",3)));
	}
	
	@Test
	public void testIsSortedList() {
		items = new ItemsSortedList(itemList);
		Assert.assertEquals(false, items.isSortedList(null));
		Assert.assertEquals(true, items.isSortedList(itemList));
		itemList.add(new Item("erreur",2.5f));
		Assert.assertEquals(false, items.isSortedList(itemList));		
	}

}
