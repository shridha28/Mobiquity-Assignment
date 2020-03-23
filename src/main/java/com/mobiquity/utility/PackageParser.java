/**
 * 
 */
package com.mobiquity.utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;

import com.mobiquity.beans.Item;
import com.mobiquity.exception.APIException;
import com.mobiquity.exception.ApproachNotFoundException;
import com.mobiquity.exception.PackageParseException;
import com.mobiquity.packer.Packer;
import com.mobiquity.solution.DynamicSolvable;
import com.mobiquity.solution.Profitable;
import com.mobiquity.solution.RecursiveSolvable;

/**
 * @author Shridha S Jalihal
 * Class to parse the package and add it to the Package list
 */
public class PackageParser {

	//Below variable used for logging
	public static final Logger logger = Logger.getLogger(Packer.class);

	Profitable profitable;

	/**
	 * @param s of type String for Parsing
	 * @param type Type of the approach to solve the Package Problem
	 * @return 
	 */
	public static String parseAndProcessPackage(String s,String type) throws APIException {

		String valueItems = "";
		if(!s.isBlank()) {
			List<Item> items = null;

			String splits[] =  s.split(":");

			if(splits.length==2) {

				try {
					if(Double.valueOf(splits[0].trim())<0){
						logger.error("Package limit cannot be negative");
						throw new PackageParseException("Package limit cannot be negative");
					}
					if(Double.valueOf(splits[0].trim())>100) {
						logger.error("Package limit cannot exceed 100");
						throw new PackageParseException("Package limit cannot exceed 100");
					}
				}catch(NumberFormatException ne) {
					logger.error(ne);
					throw new PackageParseException("Error Parsing Weight Limit is not in correct format");
				}

				String splitter [] = splits[1].split(" ");

				if(splitter.length>0) {
					items = new ArrayList<Item>();

					for(String pack: splitter) {


						if(!pack.isEmpty()) {
							String sub = pack.substring(1,pack.length()-1);

							splitter = sub.split(",");
							if(splitter.length==3) {

								Item packTemp = new Item(
										Integer.valueOf(splitter[0]),
										Double.valueOf(splitter[1]),
										Double.valueOf(splitter[2].substring(1)));

								items.add(packTemp);
							}

						}
					}
					/* Filter the items list to remove the invalid items whose weight or price is greater than 100*/
					items =  items.stream().filter((item)->(item.getPrice()<=100 &&
							item.getWeight()<=100)).collect(Collectors.toList());

					logger.info("Solving the package problem with the approach:"+type);
					try {
						valueItems = ProfitableFactory.getProfitable(type).calculateProfit(Double.valueOf(splits[0].trim()), items);
					}catch(ApproachNotFoundException e){
						logger.error(e);
						e.printStackTrace();
					}
				}
			}
		}

		else {
			logger.error("The package is blank,cannot be parsed");
			throw new PackageParseException("The package is blank,cannot be parsed");
		}

		return valueItems;

	}

}
