/**
 * 
 */
package com.mobiquityinc.packer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.mobiquity.exception.APIException;
import com.mobiquity.exception.PackageParseException;
import com.mobiquity.packer.Packer;
import com.mobiquity.utility.PackageParser;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Shridha Jalihal
 *
 */
public class packTest {
	
	
	String validString = "2,7";
	
	
	/**
	 * Test to verify if the function returns valid output for the input file with all items
	 */
	@Test
	public void testPackageParser_input1() throws APIException {
		
		String filePath = "C:\\\\Users\\\\acer\\\\Desktop\\\\MyProject\\\\Mobiquity Java assignment\\\\src\\\\test\\\\java\\\\resources\\\\validInputFile.txt";
					
		validString="4\n-\n2,7\n8,9\n";
		String txt = Packer.pack(filePath);
		//RecursiveSolvable profitable = new RecursiveSolvable();
		assertEquals(validString, Packer.pack(filePath));
	}
	
	

}
