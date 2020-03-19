/**
 * 
 */
package com.mobiquityinc.packer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * @author Shridha
 *
 */

public class PackerTest {	
	
	public static final String FILE_PATH = "C:\\Users\\acer\\Desktop\\MyProject"
			+ "\\Mobiquity Java assignment\\src\\main\\java\\com\\mobiquity\\packer\\sample.txt";
	
	FileInputStream fileInputStream;
	
	File file;
	
	InputStreamReader inputStreamReader;
	
	@BeforeEach
	void setUpResources() throws FileNotFoundException {
	
		file = new File(FILE_PATH);
		
	}
	
	
	@Test
	void testIfFileExists_ElseFailIt() throws IOException {
		String line = null;
		try {			
			fileInputStream = new FileInputStream(file);
			try {
				inputStreamReader = new InputStreamReader(fileInputStream,"UTF-8");
				BufferedReader br = new  BufferedReader(inputStreamReader);
				while((line=br.readLine())!=null) {
					System.out.println(line);
				}
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	@AfterEach()
	void cleanUpResources() {
		try {
			fileInputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
