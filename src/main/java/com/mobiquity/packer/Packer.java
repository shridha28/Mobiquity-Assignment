package com.mobiquity.packer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import com.mobiquity.exception.APIException;
import com.mobiquity.solution.Recursive;
import com.mobiquity.utility.PackageParser;
import com.mobiquity.utility.Utility;
/**
 * This class is the main class to get the packages from a file, parse the packages and 
 * process them using KnapSack solution to find the packages having maximum price and
 * weight less than or equal to the weight limit
 * 
 * @author: Shridha Jalihal
 * 
 */
public class Packer {

	private Packer() {
	}
	
	/**
	 * @param filePath to retrive the packages
	 * @return package indices to get the maximum profit
	 */
	public static String pack(String filePath) throws APIException {

			List<String> lines = Utility.readFile(filePath);
			
			lines.forEach((s)->{
				try {
					PackageParser.parsePackage(s);
					
					
				} catch (APIException e) {
					e.printStackTrace();
				}
			});
		return null;
	}

	
	/**
	 * 
	 * main method
	 */
	public static void main(String args[]) {

		try {
			pack("C:\\Users\\acer\\Desktop\\MyProject\\Mobiquity Java assignment\\src\\main\\java\\com\\mobiquity\\packer\\sample.txt");
		} catch (APIException e) {
			e.printStackTrace();
		}
	}
	
	}
