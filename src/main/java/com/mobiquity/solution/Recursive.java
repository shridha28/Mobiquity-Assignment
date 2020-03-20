/**
 * 
 */
package com.mobiquity.solution;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import com.mobiquity.beans.Package;


/**
 * @author Shridha S Jalihal
 * Concrete implementation of Profitable to return the most profit
 * pairs of weights and prices given the weight limit
 */
public class Recursive implements Profitable {


	List<Package> packages = null;
	double weightLimit = 0;

	public boolean onlyIntegerWeigths(List<Package> items) {

		boolean allIntegers = true;
		for (Package i : items) {
			if (i.getWeight() != Math.floor(i.getWeight())) {
				allIntegers = false;
				break;
			}
		}
		return allIntegers;
	}

	@Override
	public void calculateProfit(double weightLimit, List<Package> packages) {

		if (!onlyIntegerWeigths(packages)) {
			weightLimit *= 100;
			packages.stream().forEach(i -> i.setWeight(i.getWeight() * 100));
		}

		this.packages = packages;
		this.weightLimit = weightLimit;

		Map<Integer,TreeSet<Package>> hashMap = new HashMap(); 

		Package defaultP = new Package(0,0.0,0.0);

		Integer setIndex = 0;
		for(Package pack:packages) {

			TreeSet<Package> set = new TreeSet<Package>();
			set.add(defaultP);
			if(setIndex>0) {

				TreeSet<Package> previousSet = hashMap.get(setIndex-1);
				set.addAll(previousSet);
				for(Package prevSet : previousSet) {
					if(pack.getWeight()<=weightLimit &&
							(prevSet.getWeight()+pack.getWeight())<=weightLimit) {

						double weight = pack.getWeight()+prevSet.getWeight();
						double price = pack.getPrice()+prevSet.getPrice();
						Package lastPack = set.headSet(new Package(-1,weight,price)).last();
						if(lastPack.getPrice()<=price
								&&lastPack.getWeight()>weight) {
							set.remove(lastPack);
						}
						set.add(new Package(-1,pack.getWeight()+prevSet.getWeight(),
								pack.getPrice()+prevSet.getPrice()));
					}
				}
			}
			else {
				if(pack.getWeight()<weightLimit) {
					set.add(pack);
				}
			}
			hashMap.put(setIndex, set);
			setIndex++;
			System.out.println("Set"+setIndex+":"+ set);
		}

		Package highest = hashMap.get(setIndex-1).last();

		double counter = highest.getWeight();
		setIndex-=1;

		int packIndex=0;

		while(counter>0) {
			if(hashMap.get(setIndex).contains(highest)) {
				packIndex = setIndex;
				if(packIndex==0)
					break;
				setIndex--;
			}
			else {
				System.out.println("Valid indices"+packIndex);
				System.out.println(packages.get(packIndex));
				highest = new
						Package(-1,highest.getWeight()-packages.get(packIndex).getWeight(),
								highest.getPrice()-packages.get(packIndex).getPrice());
				counter-=packages.get(packIndex).getWeight();
			}
		}

		if(packIndex==0 && hashMap.get(setIndex).contains(highest)) {
			System.out.println("Valid indices"+packIndex);
			System.out.println(packages.get(packIndex));
		}
	}
}

