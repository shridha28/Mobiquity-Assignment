/**
 * 
 */
package com.mobiquityinc.packer;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.mobiquity.utility.Utility;


/**
 * @author Shridha
 *
 */

public class UtilityTest {
	
	
	public static final String VALID_FILE = "C:\\Users\\acer\\Desktop\\MyProject"
			+ "\\Mobiquity Java assignment\\src\\main\\java\\com\\mobiquity\\packer\\sample.txt";
	
	
	public static final String EMPTY_FILE = "C:\\Users\\acer\\Desktop\\MyProject"
			+ "\\Mobiquity Java assignment\\src\\main\\java\\com\\mobiquity\\packer\\EmptyFile.txt";
	
	public static final String INVALID_FILE = "C:\\Users\\acer\\Desktop\\MyProject"
			+ "\\Mobiquity Java assignment\\src\\main\\java\\com\\mobiquity\\packer\\invalidFile.txt";
	
	File file;
	
	List<String> list;
	
	Utility utility;
	
		
	@Test
	void readFile_validFileAndUTFFormat_listOfStrings() throws IOException {
		 list = Utility.readFile(VALID_FILE);
		 Assertions.assertNotNull(list);
		 Assertions.assertNotEquals(0, list.size());
	}
	
	
	@Test
	void readFile_emptyFile_EmptyList() throws IOException {
		 list = Utility.readFile(EMPTY_FILE);
		 Assertions.assertEquals(0, list.size());
	}
	

	boolean fileExists(String fileName) {
		File file = new File(fileName);
		return file.exists();
	}
}
