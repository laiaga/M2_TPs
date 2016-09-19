package item;
/**
 * This class defines the type Items of object that a client can buy.
 * An item is defined by its price and name
 * @author PR
 * @version 1.0
 **/
public class Item {
	private String name;
	private float price;

	public Item(String name, float price){
		this.name=name;
		this.price=price;
	}

	/*
	 * @return attribute name
	 */
	public String getName(){
		return this.name;
	}
	/*
	 * @return attribute price
	 */
	public float getPrice(){
		return this.price;
	}
	/*
	 * setter for name
	 * @param the new  name
	 */
	public  void setName(String name){
		this.name=name;
	}
	/*
	 * setter for price
	 * @param the new price
	 */
	public void setPrice(float price){
		this.price=price;
	}
	/*operations for comparing Items*/
	
	/**
	 * @param item to be compared with current
	 * @return true iff current price is greater or equal to item price
	 */
	public boolean greaterEqualtPrice(Item item){
		return this.getPrice()>=item.getPrice();
	}
	/**
	 * @param item to be compared with current
	 * @return true iff current price is strictly than greater item price
	 */
	public boolean greaterThanPrice(Item item){
		return this.getPrice()>item.getPrice();
	}
	/**
	 * @param item to be compared with current
	 * @return true iff current price is less than or equal to item price
	 */
	public boolean lessEqualPrice(Item item){
		return this.getPrice()<=item.getPrice();
	}
	/**
	 * @param item to be compared with current
	 * @return true iff current price is strictly less than item price
	 */
	public boolean lessThanPrice(Item item){
		return this.getPrice()<item.getPrice();
	}

	/*for latter use*/
	public boolean greaterEqualName(Item item){
		if (this.getName().compareTo(item.getName())>0){
			return true;
		} else {
			return false;
		}
	}
	/**
	 * @param item to compare with current
	 * @return true iff current and item are equal (equal values of price and name)
	 */
	public boolean isSameArticle(Item item){
		return (this.getPrice()==item.getPrice() 
				&& this.getName().equals(item.getName()));
	}
}
