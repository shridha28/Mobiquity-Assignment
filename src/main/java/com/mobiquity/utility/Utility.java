/**
 * 
 */
package com.mobiquity.utility;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.mobiquity.beans.Item;

/**
 * Common Utility for the application
 * @author Shridha Jalihal
 *
 */
public class Utility {
	
	
	
	/**Method to read file and return lines of String
	 * @param fileName String
	 * @return List of String lines
	 */
	public static List<String> readFile(String fileName){
		List<String> lines = null;

		Path path = Paths.get(fileName);
		try {
			lines = Files.lines(path).collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lines;
	}
	
	
	/**Method to sort the items based on price and weight for RecursiveSolvable
	 * @return Comparator for sorting items
	 */
	public static Comparator<Item> sortItemsForRecursion(){
		Comparator<Item> comparator =
				(s1,s2)->{ 
					int c = Double.compare(s1.getPrice(),s2.getPrice());

					if(c==0) return Double.compare(s1.getWeight(),s2.getWeight());
					return c;
				};

				return comparator;
	}
	

	
	
	/**Method to sort the items based on price and weight for DynamicSolvable
	 * @return Comparator for sorting items
	 */
	public static Comparator<Item> sortItemsForDynamic(){
		Comparator<Item> comparator =
				(s1,s2)->{ 
					int c = Double.compare(s1.getPrice(),s2.getPrice());

					if(c==0) return Double.compare(s2.getWeight(),s1.getWeight());
					return c;
				};

				return comparator;
	}

}
