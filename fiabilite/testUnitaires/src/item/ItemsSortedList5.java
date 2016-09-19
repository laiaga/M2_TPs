package item;

import java.util.ArrayList;

public class ItemsSortedList5 implements IItemsSortedList{

	
	private ArrayList<Item> panierList;
	
	/*
	 * a successful build requires that the argument is sorted
	 * otherwise the attribute panierList is set to null 
	 */
	public ItemsSortedList5( ArrayList<Item> l){
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
		/*TODO*/
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
		int i=0,j=sizePanier-1,m=0;
		boolean found=false;
		while (i!=j) {
			m=(i+j)/2;
		if (this.panierList.get(m).lessEqualPrice(item)){
			i=m;
			} else {
				j=m;
			}
		}
		return found;
	}	
		
}
