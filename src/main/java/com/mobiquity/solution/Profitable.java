/**
 * 
 */
package com.mobiquity.solution;

import java.util.List;

import com.mobiquity.beans.Item;

/**
 * @author Shridha Jalihal
 *
 */
public interface Profitable {

	/**
	 * @param weightLimit
	 * @param items of a package
	 * @return String containing selected item indices
	 */
	String calculateProfit(double weightLimit, List<Item> packages);

}
