/**
 * 
 */
package com.mobiquity.solution;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import com.mobiquity.beans.Item;
import com.mobiquity.utility.Utility;


/**
 * @author Shridha S Jalihal
 * Concrete implementation of Profitable to return the most profit
 * pairs of weights and prices given the weight limit.
 * The solution uses set method to find the profit and listOfItems.
 */
public class DynamicSolvable implements Profitable {


	@Override
	public String calculateProfit(double weightLimit, List<Item> listOfItems) {

		Map<Integer,TreeSet<Item>> hashMap = new HashMap(); 
		Item defItem = new Item(0,0.0,0.0);
		
		/*
		 * Check if the items have decimal weights,
		 * if yes then convert to rounded values
		 * */
		
		if (!checkForNonIntegerWeights(listOfItems)) {
			weightLimit *= 100;
			listOfItems.stream().forEach(i -> i.setWeight(i.getWeight() * 100));
		}


		Integer setIndex = 0;

		for(Item pack:listOfItems) {

			
			TreeSet<Item> set = new TreeSet<Item>(Utility.sortItemsForDynamic());
			/* Add the default item to the set*/
			set.add(defItem);
			
			/* for set size greater than 1*/
			if(setIndex>0) {
				TreeSet<Item> previousSet = hashMap.get(setIndex-1);
				set.addAll(previousSet);
				
				/* Add the current item's weight and price to every previous set's weight and price in the map. 
				 * If the weight exceeds the weight limit,discard the set.
				 */
				
				for(Item prevSet : previousSet) {
					
					if(pack.getWeight()<=weightLimit &&
							(prevSet.getWeight()+pack.getWeight())<=weightLimit) {

						double weight = pack.getWeight()+prevSet.getWeight();
						double price = pack.getPrice()+prevSet.getPrice();
						
						Item lastPack = set.headSet(new Item(0,weight,price)).last();
						
					/* Check that if the weight increases,then the profit also increases. If not discard the 
					 * previous set. 
					 */
						if(lastPack.getPrice()<=price
								&& lastPack.getWeight()>weight) {
							set.remove(lastPack);
						}
						set.add(new Item(0,pack.getWeight()+prevSet.getWeight(),
								pack.getPrice()+prevSet.getPrice()));
					}
				}
			}
			/* If set does not contain any items,then add the item by default if its weight is<= weightlimit*/
			else {
				if(pack.getWeight()<weightLimit) {
					set.add(pack);
				}
			}
			
			/* Add the set to the indexed map*/
			hashMap.put(setIndex, set);
			setIndex++;
		}

		//Get the highest item present in the map
		Item highest = hashMap.get(setIndex-1).last();
		
		double counter = highest.getWeight();
		
		setIndex-=1;
		int packIndex=0;
		String valPackIndices = "";
		
		/* Loop over till the weight >0 to find the valid indices
		 * If an item is present in multiple sets, the smallest index is the valid index*/
		if(!highest.equals(defItem)) {
			while(counter>0) {
				if(hashMap.get(setIndex).contains(highest)) {
					packIndex = setIndex;
					if(packIndex==0)
						break;
					setIndex--;
				}
				else {
					valPackIndices=listOfItems.get(packIndex).getIndex()+","+valPackIndices;
					highest = new
							Item(0,highest.getWeight()-listOfItems.get(packIndex).getWeight(),
									highest.getPrice()-listOfItems.get(packIndex).getPrice());
					counter-=listOfItems.get(packIndex).getWeight();
				}
			}
			
			/* Include the first index,if its a part of valid indices*/
			if(packIndex==0 && hashMap.get(setIndex).contains(highest)) {
				valPackIndices=listOfItems.get(packIndex).getIndex()+","+valPackIndices;
			}
		}

   
		/* send "-" for no valid indices or String of valid indices */
		 if(valPackIndices.isBlank())   
		    return "-";
		 if(Character.isDigit(valPackIndices.charAt(valPackIndices.length()-1)))
		    return valPackIndices;
		 else{
			 valPackIndices = valPackIndices.substring(0,valPackIndices.length()-1);
			 return valPackIndices;
		  }
}
	
	
	/**
	 *@param items to check for any non-Integer weights
	 *@return boolean true if none are non-Integers , else return false 
	 */
	public boolean checkForNonIntegerWeights(List<Item> items) {

		boolean areAllInts = true;
		for (Item i : items) {
			if (i.getWeight() != Math.floor(i.getWeight())) {
				areAllInts = false;
				break;
			}
		}
		return areAllInts;
	}
	
}

