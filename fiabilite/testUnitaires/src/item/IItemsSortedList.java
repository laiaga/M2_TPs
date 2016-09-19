package item;

import java.util.ArrayList;

public interface IItemsSortedList {
	
	boolean isPresentArticle(Item item);
	
	/**
	 * Spécifications : 
	 * Prend en paramètre une liste
	 * Renvoie true ssi la liste est triée dans l'ordre croissant
	 * Liste vide -> false
	 */
	boolean isSortedList(ArrayList<Item> l);
}
