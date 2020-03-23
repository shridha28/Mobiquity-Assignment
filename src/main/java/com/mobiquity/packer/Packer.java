package com.mobiquity.packer;

import java.util.List;

import org.apache.log4j.Logger;

import com.mobiquity.exception.APIException;
import com.mobiquity.utility.PackageParser;
import com.mobiquity.utility.Utility;

/**
 * This class is the main class to get the packages from a file, parse the
 * packages and process them using KnapSack solution to find the packages having
 * maximum price and weight less than or equal to the weight limit
 **/
public class Packer {
	
	//Below variable used for logging
	public static final Logger logger = Logger.getLogger(Packer.class);

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

		lines.forEach((s) -> {
			try {
				logger.debug("Parsing for input:"+s);
				sb.append(PackageParser.parseAndProcessPackage(s,"DynamicSolvable"));
				sb.append("\n");

			} catch (APIException e) {
				e.printStackTrace();
			}
		});
		return sb.toString();
	}

	/**
	 * @param args Array of Strings from command line main method
	 */
	public static void main(String args[]) {
		
		try {
			if(args.length==0) {
				args = new String[]{ "./src/main/java/sample.txt"};
				logger.debug("Input file path:"+args[0]);
			}
			String output = pack(args[0]);
			System.out.println(output);
			logger.info("Output after parsing package and applying logic:\n"+output);

		} catch (APIException e) {
			e.printStackTrace();
			logger.error(e);
		}
	}

}
