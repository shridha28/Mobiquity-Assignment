package com.mobiquity.beans;


/**
 * @author Shridha S Jalihal
 * Item Bean to build a package.
 */
public class Item implements Comparable<Item>{

	private	int index;
	private	double weight;
	private	double  price;


	public void setIndex(int index) {
		this.index = index;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public int getIndex() {
		return index;
	}

	public double getWeight() {
		return weight;
	}

	public double getPrice() {
		return price;
	}

	public Item(int index, double weight, double price) {
		super();
		this.index = index;
		this.weight = weight;
		this.price = price;
	}

	public Item() {}


	@Override
	public String toString() {
		return "Item [index=" + index + ", weight=" + weight + ", price="+ price+"]";
	}

	
	@Override
	public boolean equals(Object object) {
		Item pack = (Item) object;

		if(this.getPrice()-pack.getPrice()==0 &&
				this.getWeight()-pack.getWeight()==0)
			return true;
		return false;
	}

	@Override
	public int compareTo(Item o) {
		int c = Double.compare(this.getPrice(),o.getPrice());
		if(c==0)
			return Double.compare(o.getWeight(),this.getWeight());
		return c;
	}
}
