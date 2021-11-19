package com.teller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileUtils {
	
	
	public Scanner getscanner(String path) throws FileNotFoundException {
		
	   return new Scanner(getfile(path));
		
	}
	
	private File getfile(String path) {
		
		return new File(path);
	}
	
	

}
