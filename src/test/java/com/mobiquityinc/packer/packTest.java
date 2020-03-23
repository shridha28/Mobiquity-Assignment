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

/**PackTest method to test the output of a file.
 * @author Shridha Jalihal
 **/

public class PackTest {
	
	
	String validString = "2,7";
	
	
	/**@throws APIException
	 * Test to verify if the function returns valid output for the input file with all items.
	 */
	@Test
	public void testPackMethod() throws APIException {
		
		String filePath = "./src/main/java/sample.txt";
					
		validString="8,9\n2,3,4,10\n1,2,5\n4\n-\n2,7\n";
		assertEquals(validString, Packer.pack(filePath));
	}
	
	

}
