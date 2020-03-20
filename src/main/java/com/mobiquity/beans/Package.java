package com.mobiquity.beans;


/**
 * @author Shridha S Jalihal
 * Immutable Package Bean with a PackageBuilder to build a package.
 */
public class Package implements Comparable<Package>{
	
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

	public Package(int index, double weight, double price) {
		super();
		this.index = index;
		this.weight = weight;
		this.price = price;
	}
	
	public boolean equals(Object object) {
		Package pack = (Package) object;
		
		if(this.getPrice()-pack.getPrice()==0 &&
				this.getWeight()-pack.getWeight()==0)
			return true;
		return false;
	}
	/*
	 * private Package (PackageBuilder builder) {
	 * 
	 * }
	 */
	
	public Package() {}
	
	
	
	/*PackageBuilder to build a Package*/
	/*
	 * public static class PackageBuilder { private Package pack;
	 * 
	 * public PackageBuilder() { pack = new Package(); }
	 * 
	 * public Package build() { return new Package(this); }
	 * 
	 * public PackageBuilder setIndex(int index) { this.pack.index = index; return
	 * this; }
	 * 
	 * public PackageBuilder setWeight(double weight) { this.pack.weight = weight;
	 * return this; }
	 * 
	 * public PackageBuilder setPrice(double price) { this.pack.price = price;
	 * return this; }
	 * 
	 * }
	 */
	public int getIndex() {
		return index;
	}

	public double getWeight() {
		return weight;
	}

	public double getPrice() {
		return price;
	}

	
	public String toString() {
		
		return "index: "+index+"price: "+price+"weight: "+weight;
	}


	@Override
	public int compareTo(Package o) {
		// TODO Auto-generated method stub
		int c = Double.compare(this.getPrice(),o.getPrice());
		if(c==0)
			return Double.compare(o.getWeight(),this.getWeight());
		return c;
	}
}
