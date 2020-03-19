/**
 * 
 */
package com.mobiquity.utility;

import java.util.ArrayList;
import java.util.List;

import com.mobiquity.exception.APIException;
import com.mobiquity.exception.PackageParseException;
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
			
			String splits[] =  s.split(":");
			
			if(splits.length==2) {
				
				String packages [] = splits[1].split(" ");
				 
				if(packages.length>0) {
					
					for(String pack: packages) {

						List<Package> packs = new ArrayList<Package>(); 
						if(!pack.isEmpty()) {
							String sub = pack.substring(1,pack.length()-1);

							packages = sub.split(",");
							if(packages.length==3) {
								
								Package packTemp = new Package.PackageBuilder()
										.setIndex(Integer.valueOf(packages[0]))
										.setWeight(Double.valueOf(packages[1]))
										.setPrice(Double.valueOf(packages[1].substring(1)))
									    .build();
								packs.add(packTemp);
							}
							packs.sort((s1,s2)->Double.compare(s1.getWeight(),s2.getWeight()));
							System.out.println(packs+"\n");
						}
					}
				}

			}
			System.out.println("************************************************************");
		}

		else {
			throw new PackageParseException("The package is defective,cannot be parsed");
		}
	}
}
