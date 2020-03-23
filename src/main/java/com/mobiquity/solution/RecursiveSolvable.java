package com.mobiquity.solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.mobiquity.beans.Item;
import com.mobiquity.utility.Utility;

/**
 * @author Shridha S Jalihal
 * Concrete implementation of Profitable to return the most profit
 * pairs of weights and prices given the weight limit.
 * The solution uses KnapSack Recursive method to find the profitable packages.
 */
public class RecursiveSolvable implements Profitable {

	@Override
	public String calculateProfit(double weightLimit, List<Item> packages) {

		ArrayList<Integer> list = new ArrayList<Integer>();
		
       /* sort the items by price followed by weight*/
		packages.sort(Utility.sortItemsForRecursion());
		Item[] wt = packages.toArray(Item[]::new);
		
	
		//call the recursive knapsack recursive method.
		knapsack(weightLimit, wt, packages.size(), list);
		
		/* Get the list of indices and sort them to be sent back to the caller*/
		int i=0;
		for(Integer selected:list) {
			list.set(i, packages.get(selected).getIndex());
			i++;
		}
		Collections.sort(list,null);

		/*Process the list and return the indices*/
		String str = "";
		if(list.isEmpty())
			return "-";
		for(Integer selected: list) {
			str=str+selected+",";
		}
		return str.substring(0,str.length()-1);


	}

	/**
	 * @param capacity maximum weight allowed
	 * @param items Array of items
	 * @param numItems total number of items
	 * @param list List of picked packages that give maximum profit
	 * @return maximum profit
	 */
	public double knapsack(double capacity, Item[] items, int numItems, ArrayList<Integer> list){

		//Base Case
		if (numItems == 0 || capacity == 0)
			return 0;

		/* 
		 * If weight of the nth item is more than maximum capacity,
		 *  then do not include the package in the optimal solution
		 * */ 
		
		if (items[numItems-1].getWeight() > capacity)
			return knapsack(capacity, items, numItems-1, list);

		/*Return the maximum of both the cases*/
		else {
			/*When the item is picked*/
			 int preTakeSize = list.size();
			 double take = items[numItems-1].getPrice() + knapsack(capacity - items[numItems-1].getWeight(),
					items, numItems-1, list);

			/*When the item is not picked*/
			 int preDontTakeSize = list.size();
			 double dontTake = knapsack(capacity, items, numItems-1, list);

			if (take > dontTake) {
				if (list.size() > preDontTakeSize)
					list.subList(preDontTakeSize, list.size()).clear();
				list.add(Integer.valueOf(numItems - 1));
				return take;
			}
			else {
				if (preDontTakeSize > preTakeSize)
					list.subList(preTakeSize, preDontTakeSize).clear();
				return dontTake;
			}
		}     

	}


}
