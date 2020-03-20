/**
 * 
 */
package com.mobiquity.utility;

import java.util.ArrayList;
import java.util.List;

import com.mobiquity.exception.APIException;
import com.mobiquity.exception.PackageParseException;
import com.mobiquity.solution.Recursive;
import com.mobiquity.beans.Package;

/**
 * @author Shridha S Jalihal
 * Class to parse the package and add it to the Package list
 */
public class PackageParser {
	
	/**
	 * @param package of type String for Parsing
	 * @return 
	 */
	public static void parsePackage(String s) throws APIException {

		
		
		if(!s.isBlank()) {
			List<Package> packs = null;
			
			String splits[] =  s.split(":");
			
			if(splits.length==2) {
				
				String packages [] = splits[1].split(" ");
				 
				if(packages.length>0) {
					packs = new ArrayList<Package>();
					
					for(String pack: packages) {

						  
						if(!pack.isEmpty()) {
							String sub = pack.substring(1,pack.length()-1);

							packages = sub.split(",");
							if(packages.length==3) {
								
								Package packTemp = new Package(
										Integer.valueOf(packages[0]),
										Double.valueOf(packages[1]),
										Double.valueOf(packages[2].substring(1)));
									    
								packs.add(packTemp);
							}
							packs.sort((s1,s2)->Double.compare(s1.getPrice(),s2.getPrice()));
							//System.out.println(packs+"\n");
						}
					}

					new Recursive().calculateProfit(Double.valueOf(splits[0].trim()), packs);
				}

			}
			System.out.println("************************************************************");
		}

		else {
			throw new PackageParseException("The package is blank,cannot be parsed");
		}
		
		
	}
}
