package item;

import java.util.ArrayList;

public class ItemsSortedList2 implements IItemsSortedList{
	private ArrayList<Item> panierList;
	
	/*
	 * a successful build requires that the argument is sorted
	 * otherwise the attribute panierList is set to null 
	 */
	public ItemsSortedList2( ArrayList<Item> l){
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
		int i,j,m;
		boolean found;
		i=1;
		j=sizePanier;
		m=0;
		found=false;
		while (i!=j && !found) {
			m=(i+j)/2;
			if (this.panierList.get(m).lessEqualPrice(item)){
				i=m+1;
			}
			else {
				if (item.getPrice()==m){
					found=true;
				} else {
					j=m-1;
				}
			}
		}
		return found;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
