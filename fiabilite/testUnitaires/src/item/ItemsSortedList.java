package item;

import java.util.ArrayList;

public class ItemsSortedList implements IItemsSortedList {

	private ArrayList<Item> panierList;
	
	/*
	 * a successful build requires that the argument is sorted
	 * otherwise the attribute panierList is set to null 
	 */
	public ItemsSortedList( ArrayList<Item> l){
		if (isSortedList(l)){
		this.panierList=l;
		} else {
			this.panierList=null;
		}
	}
	/*
	 * @param list to test
	 * @return true iff the list is sorted according to the price of items
	 * */
	@Override
	public boolean isSortedList(ArrayList<Item> l){
		if(l == null) {
			return false;
		}
		float minPrice = 0.0f;
		for (Item item : l) {
			if( item.getPrice() < minPrice) {
				return false;
			} else {
				minPrice = item.getPrice();
			}
		}
		return true;
	}
	/*
	 * Performs a dichotomic search since panierList is always sorted 
	 * @param item the Item we are looking for
	 * @return true iff item occurs in the list
	 */
	@Override
	public boolean isPresentArticle(Item item){
		int sizePanier=this.panierList.size();
		int i,j,m;
		i=1;
		j=sizePanier;
		m=0;
		while (i!=j) {
			m=(i+j)/2;
			if (this.panierList.get(m).lessEqualPrice(item)){
				i=m;
			}
			else j=m;
		}
		return (item.isSameArticle(panierList.get(m)));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//NYI

	}

}
