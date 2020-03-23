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


/**UtilityTest class to test the read functionality of the file for an
 * empty and non-empty file
 * @author Shridha
 * */

public class UtilityTest {
	
	public static final String VALID_FILE = "./src/main/java/sample.txt";
	
	
	public static final String EMPTY_FILE = "./src/main/java/EmptyFile.txt";
	
	
	File file;
	
	List<String> list;
	
	Utility utility;
	
	//Read a non-empty valid file and return number of lines equal to the ones present in the file	
	@Test
	void readFile_validFileAndUTFFormat_listOfStrings() throws IOException {
		 list = Utility.readFile(VALID_FILE);
		 Assertions.assertNotNull(list);
		 Assertions.assertEquals(6, list.size());
	}
	
	//Read an empty file and return empty list
	@Test
	void readFile_emptyFile_EmptyList() throws IOException {
		 list = Utility.readFile(EMPTY_FILE);
		 Assertions.assertEquals(0, list.size());
	}
	
	
}
