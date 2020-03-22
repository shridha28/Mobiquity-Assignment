/**
 * 
 */
package com.mobiquity.utility;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.mobiquity.beans.Item;

/**
 * Common Utility for the application
 * @author Shridha Jalihal
 *
 */
public class Utility {
	
	
	
	/**
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
	

}
