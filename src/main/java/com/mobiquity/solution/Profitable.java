/**
 * 
 */
package com.mobiquity.solution;

import java.util.List;

import com.mobiquity.beans.Package;

/**
 * @author acer
 *
 */
public interface Profitable {
	
	//public void calculateProfit(int weightLimit,List<Package> packages);

	/**
	 * @param weightLimit
	 * @param packages
	 */
	void calculateProfit(double weightLimit, List<Package> packages);

}
