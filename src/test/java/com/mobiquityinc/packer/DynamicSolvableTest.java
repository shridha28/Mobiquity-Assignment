
package com.mobiquityinc.packer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mobiquity.beans.Item;
import com.mobiquity.solution.DynamicSolvable;
import com.mobiquity.solution.Profitable;

/**DynamicSolvableTest to test the Set method implementaton of the
 * Packages Problem.
 * @author Shridha Jalihal
 * */
public class DynamicSolvableTest {
	
	//Variable used to validate index for the below tests
	String validIndex = "";
	
	
	Profitable profitable = null;
	
	/**
	 * Interface to initialize object for calling the method in test
	 */
	@BeforeEach
	void setUp() {
		profitable = new DynamicSolvable();
	}
	
	
	/**
	 * Test to verify if the function returns valid Index. Test input 1
	 */
	@Test
	public void testRecursiveSolvable_input1() {
		
		double weightLimit = 81.0;
		validIndex = "4";
		List<Item> packages = new ArrayList();
		Item item1 = new Item(1,53.38,45);
		packages.add(item1);
		Item item2 = new Item(2,88.62,98);
		packages.add(item2);
		Item item3 = new Item(3,78.48,3);
		packages.add(item3);
		Item item4 = new Item(4,72.30,76);
		packages.add(item4);
		Item item5 = new Item(5,30.18,9);
		packages.add(item5);
		Item item6 = new Item(6,46.34,48);
		packages.add(item6);		
		
		assertEquals(validIndex, profitable.calculateProfit(weightLimit, packages));
	}

	/**
	 * Test to verify if the function returns valid Index. Test input 2
	 */
	@Test
	public void testRecursiveSolvable_input2() {
		
		double weightLimit = 8.0;
		validIndex = "-";
		List<Item> packages = new ArrayList();
		Item item1 = new Item(1,15.3,34);
		packages.add(item1);				
		
		assertEquals(validIndex, profitable.calculateProfit(weightLimit, packages));
	}
	
	/**
	 * Test to verify if the function returns valid Index. Test input 3
	 */
	@Test
	public void testRecursiveSolvable_input3() {
		
		double weightLimit = 75.0;
		validIndex = "2,7";
		List<Item> packages = new ArrayList();
		Item item1 = new Item(1,85.31,29);
		packages.add(item1);
		Item item2 = new Item(2,14.55,74);
		packages.add(item2);
		Item item3 = new Item(3,3.98,16);
		packages.add(item3);
		Item item4 = new Item(4,26.24,55);
		packages.add(item4);
		Item item5 = new Item(5,63.69,52);
		packages.add(item5);
		Item item6 = new Item(6,76.25,75);
		packages.add(item6);	
		Item item7 = new Item(7,60.02,74);
		packages.add(item7);
		Item item8 = new Item(8,93.18,35);
		packages.add(item8);
		Item item9 = new Item(9,89.95,78);
		packages.add(item9);

		assertEquals(validIndex, profitable.calculateProfit(weightLimit, packages));
	}
	
	/**
	 * Test to verify if the function returns valid Index. Test input 4
	 */
	@Test
	public void testRecursiveSolvable_input4() {
		
		double weightLimit = 56.0;
		validIndex = "8,9";
		List<Item> packages = new ArrayList();
		Item item1 = new Item(1,90.72,13);
		packages.add(item1);
		Item item2 = new Item(2,33.80,40);
		packages.add(item2);
		Item item3 = new Item(3,43.15,10);
		packages.add(item3);
		Item item4 = new Item(4,37.97,16);
		packages.add(item4);
		Item item5 = new Item(5,46.81,36);
		packages.add(item5);
		Item item6 = new Item(6,48.77,79);
		packages.add(item6);	
		Item item7 = new Item(7,81.80,45);
		packages.add(item7);
		Item item8 = new Item(8,19.36,79);
		packages.add(item8);
		Item item9 = new Item(9,6.76,64);
		packages.add(item9);
		
		assertEquals(validIndex, profitable.calculateProfit(weightLimit, packages));
	}
}
