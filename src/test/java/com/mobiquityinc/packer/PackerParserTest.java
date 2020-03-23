/**
 * 
 */
package com.mobiquityinc.packer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mobiquity.exception.APIException;
import com.mobiquity.exception.PackageParseException;
import com.mobiquity.utility.PackageParser;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Shridha Jalihal
 *
 */
public class PackerParserTest {
	
	//Variable used to validate index in the below tests
	String validIndex = "";
	
	String solveMethod = "DynamicSolvable";
	
	
	/**
	 * Test to verify if the function returns valid Index for the package string. Test input 1
	 */
	@Test
	public void testPackageParser_input1() throws APIException {
		
		String inputPackageValues ="81 : (1,53.38,€45) (2,88.62,€98) (3,78.48,€3) (4,72.30,€76) (5,30.18,€9) (6,46.34,€48)";	
		validIndex="4";
		assertEquals(validIndex, PackageParser.parseAndProcessPackage(inputPackageValues,solveMethod));
	}
	
	/**
	 * Test to verify if the function returns valid Index for the package string. Test input 2
	 */
	@Test
	public void testPackageParser_input2() throws APIException {
		
		String inputPackageValues ="8 : (1,15.3,€34)";		
		validIndex="-";
		assertEquals(validIndex, PackageParser.parseAndProcessPackage(inputPackageValues,solveMethod));
	}
	
	/**
	 * Test to verify if the function returns valid Index for the package string. Test input 3
	 */
	@Test
	public void testPackageParser_input3() throws APIException {
		
		String inputPackageValues ="75 : (1,85.31,€29) (2,14.55,€74) (3,3.98,€16) (4,26.24,€55) (5,63.69,€52) (6,76.25,€75) (7,60.02,€74) (8,93.18,€35) (9,89.95,€78)";			
		validIndex="2,7";
		assertEquals(validIndex, PackageParser.parseAndProcessPackage(inputPackageValues,solveMethod));
	}
	
	/**
	 * Test to verify if the function returns valid Index for the package string. Test input 4
	 */
	@Test
	public void testPackageParser_input4() throws APIException {
		
		String inputPackageValues ="56 : (1,90.72,€13) (2,33.80,€40) (3,43.15,€10) (4,37.97,€16) (5,46.81,€36) (6,48.77,€79) (7,81.80,€45) (8,19.36,€79) (9,6.76,€64)";				
		validIndex="8,9";
		assertEquals(validIndex, PackageParser.parseAndProcessPackage(inputPackageValues,solveMethod));
	}
	
	/**
	 * Test to verify if the function returns API exception for negative weight limit
	 */
	@Test
	public void testPackageParser_negativeWeightLimit() throws APIException {
		
		String inputPackageValues ="-56 : (1,90.72,€13) (2,33.80,€40) (3,43.15,€10) (4,37.97,€16) (5,46.81,€36) (6,48.77,€79) (7,81.80,€45) (8,19.36,€79) (9,6.76,€64)";
		
		 Assertions.assertThrows(PackageParseException.class, () -> {
			 PackageParser.parseAndProcessPackage(inputPackageValues,solveMethod);
			  });
	}
	
	/**
	 * Test to verify if the function returns API exception weight greater than 100
	 */
	@Test
	public void testPackageParser_weightLimit() throws APIException {
		
		String inputPackageValues ="101 : (1,90.72,€13) (2,33.80,€40) (3,43.15,€10) (4,37.97,€16) (5,46.81,€36) (6,48.77,€79) (7,81.80,€45) (8,19.36,€79) (9,6.76,€64)";
	
		 Assertions.assertThrows(PackageParseException.class, () -> {
			 PackageParser.parseAndProcessPackage(inputPackageValues,solveMethod);
			});
	}
		
	/**
	 * Test to verify if the function picks item with max price of 100
	 */
	@Test
	public void testPackageParser_picMaxPrice() throws APIException {
		
		String inputPackageValues ="75 : (1,85.31,€29) (2,14.55,€74) (3,3.98,€16) (4,26.24,€55) (5,63.69,€52) (6,76.25,€75) (7,60.02,€74) (8,93.18,€35) (9,89.95,€78) (10,14.55,€100)";		
		validIndex="2,3,4,10";
		assertEquals(validIndex, PackageParser.parseAndProcessPackage(inputPackageValues,solveMethod));
	}
	
	/**
	 * Test to verify if the function excludes item with price greater than 100
	 */
	@Test
	public void testPackageParser_priceLimit() throws APIException {
		
		String inputPackageValues ="75 : (1,85.31,€29) (2,14.55,€74) (3,3.98,€16) (4,26.24,€55) (5,63.69,€52) (6,76.25,€75) (7,60.02,€74) (8,93.18,€35) (9,89.95,€78) (10,14.55,€101)";	
		validIndex="2,7";
		assertEquals(validIndex, PackageParser.parseAndProcessPackage(inputPackageValues,solveMethod));
	}

}
