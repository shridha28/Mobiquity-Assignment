package com.mobiquity.solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.mobiquity.beans.Item;

/**
 * @author Shridha S Jalihal
 * Concrete implementation of Profitable to return the most profit
 * pairs of weights and prices given the weight limit.
 * The solution uses Recursive method to find the profitable packages.
 */
public class RecursiveSolvable implements Profitable {

	@Override
	public String calculateProfit(double weightLimit, List<Item> packages) {


		Item[] wt = packages.toArray(Item[]::new);

		
		/*
		 * Collections.sort(packages,(s1,s2)->{ int c =
		 * Double.compare(s1.getPrice(),s2.getPrice()); if(c==0) return
		 * Double.compare(s2.getWeight(),s1.getWeight()); return c;});
		 */

		ArrayList<Integer> list = new ArrayList<Integer>();
		knapsack(weightLimit, wt, packages.size(), list);

		String str = "";
		if(list.isEmpty())
			return "-";
		for(Integer selected: list) {
			str=str+packages.get(selected).getIndex()+",";
		}
		return str.substring(0,str.length()-1);


	}

	/**
	 * @param maximum weight allowed
	 * @param Array of packages
	 * @param total number of packages
	 * @param List of picked packages that give maximum profit
	 * @return maximum profit
	 */
	public double knapsack(double capacity, Item[] items, int numPackages, ArrayList<Integer> list){

		//Base Case
		if (numPackages == 0 || capacity == 0)
			return 0;

		/* 
		 * If weight of the nth item is more than maximum capacity,
		 *  then do not include the package in the optimal solution
		 * */ 
		
		if (items[numPackages-1].getWeight() > capacity)
			return knapsack(capacity, items, numPackages-1, list);

		/*Return the maximum of both the cases*/
		else {
			/*When the item is picked*/
			 int preTakeSize = list.size();
			 double take = items[numPackages-1].getPrice() + knapsack(capacity - items[numPackages-1].getWeight(),
					items, numPackages-1, list);

			/*When the item is not picked*/
			 int preDontTakeSize = list.size();
			 double dontTake = knapsack(capacity, items, numPackages-1, list);

			if (take > dontTake) {
				if (list.size() > preDontTakeSize)
					list.subList(preDontTakeSize, list.size()).clear();
				list.add(Integer.valueOf(numPackages - 1));
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
