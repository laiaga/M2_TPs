package monapp;

import java.io.Serializable;

public class Product implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String name;
	String price;
	String desc;

	public Product() {
	};

	public String getName() {
		return name;
	}

	public String getPrice() {
		return price;
	}

	public String getDesc() {
		return desc;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
