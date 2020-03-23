/**
 * 
 */
package com.mobiquity.solution;

import java.util.List;

import com.mobiquity.beans.Item;

/**Interface for the solution to solve the Packages Problem
 * @author Shridha Jalihal
 *
 */
public interface Profitable {

	/**Method to calculate Profit
	 * @param weightLimit weight limit to find the packages
	 * @param items of a package
	 * @return String containing selected item indices
	 */
	String calculateProfit(double weightLimit, List<Item> items);

}
