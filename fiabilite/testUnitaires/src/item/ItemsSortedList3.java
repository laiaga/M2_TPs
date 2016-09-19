package item;

import java.util.ArrayList;

public class ItemsSortedList3 implements IItemsSortedList{
	private ArrayList<Item> panierList;
	
	/*
	 * a successful build requires that the argument is sorted
	 * otherwise the attribute panierList is set to null 
	 */
	public ItemsSortedList3( ArrayList<Item> l){
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
		while (i<j && !found) {
			m=(i+j)/2;
			if (this.panierList.get(m).isSameArticle(item)){
				found=true;
			}
			else {
				if (item.lessThanPrice(this.panierList.get(m))){
					found=true;
				} else { 
					i=m+1;
				}
			}
		}
		return found;
	}	

}
