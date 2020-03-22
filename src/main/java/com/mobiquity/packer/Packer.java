package com.mobiquity.packer;

import java.util.List;

import com.mobiquity.exception.APIException;
import com.mobiquity.utility.PackageParser;
import com.mobiquity.utility.Utility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * This class is the main class to get the packages from a file, parse the packages and 
 * process them using KnapSack solution to find the packages having maximum price and
 * weight less than or equal to the weight limit
 * 
 *
 * 
 */
public class Packer {
	
	private static Logger logger = LoggerFactory.getLogger(Packer.class);
	

	private Packer() {
	}
	
	/**
	 * @param filePath to parse and find the maximum profit packages
	 * @return package indices to get the maximum profit
	 * @throws APIException Throws exception when the package is invalid
	 */
	public static String pack(String filePath) throws APIException {

			List<String> lines = Utility.readFile(filePath);
			StringBuilder sb = new StringBuilder();
			
			lines.forEach((s)->{
				try {

				  sb.append(PackageParser.parseAndProcessPackage(s));
				  sb.append("\n");
					
				} catch (APIException e) {
					e.printStackTrace();
				}
			});
		return sb.toString();
	}

	
	/**
	 * @param args Array of Strings from command line
	 * main method
	 */
	public static void main(String args[]) {

		try {
			String filePath = "C:\\\\Users\\\\acer\\\\Desktop\\\\MyProject\\\\Mobiquity Java assignment\\\\src\\\\main\\\\java\\\\com\\\\mobiquity\\\\packer\\\\sample.txt";
			logger.debug("Inside void main function");
			logger.debug("Path of file:"+ filePath);
			System.out.println(pack(filePath));
			
		} catch (APIException e) {
			e.printStackTrace();
		}
	}
	
	}
