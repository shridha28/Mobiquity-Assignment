package com.mobiquity.beans;


/**
 * @author Shridha S Jalihal
 * Immutable Package Bean with a PackageBuilder to build a package.
 */
public class Package{
	
private	int index;
private	double weight;
private	double  price;
	
	
	private Package(int index, double weight, double price) {
		super();
		this.index = index;
		this.weight = weight;
		this.price = price;
	}
	
	private Package (PackageBuilder builder) {
		
	}
	
	private Package() {}
	
	/*PackageBuilder to build a Package*/
	public static class PackageBuilder {
        private Package pack;

     public PackageBuilder() {
        	pack = new Package(); 
        }

       public Package build() {
        	return new Package(this);
        }

        public PackageBuilder setIndex(int index) {
            this.pack.index = index;
            return this;
        }

        public PackageBuilder setWeight(double weight) {
            this.pack.weight = weight;
            return this;
        }

        public PackageBuilder setPrice(double price) {
            this.pack.price = price;
            return this;
        }

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

	
	public String toString() {
		
		return "index:"+index+"price:"+price+"weight:"+weight;
	}
}
