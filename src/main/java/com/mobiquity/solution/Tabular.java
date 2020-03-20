/**
 * 
 */
package com.mobiquity.solution;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.mobiquity.beans.Package;

/**
 * @author Shridha S Jalihal
 * Concrete implementation of Profitable to return the most profit
 * pairs of weights and prices given the weight limit
 */
public class Tabular {


	public void calculateProfit(int weightLimit, List<Package> packages) {
	
		List<Double> weights = packages
							   .parallelStream()
				               .map((pack)->pack.getWeight())
				               .collect(Collectors.toList());
		
		List<Double> prices = packages
				   .parallelStream()
	               .map((pack)->pack.getPrice())
	               .collect(Collectors.toList());
		
		
		double [][] table = new double[weightLimit+1][packages.size()+1];
		
        
		
	}

}
