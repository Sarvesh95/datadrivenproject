package com.sar.roughwork;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {
	
	public static void main(String[] args) throws FileNotFoundException {
		 Properties config = new Properties();
		 Properties OR = new Properties();
		 FileInputStream fil = new FileInputStream("C:\\Users\\sarve\\eclipse-workspace\\DataDriven\\src\\test\\resources\\properties\\OR.properties");
		 FileInputStream file = new FileInputStream("C:\\Users\\sarve\\eclipse-workspace\\DataDriven\\src\\test\\resources\\properties\\Config.properties");
		 try {
			config.load(file);
			config.getProperty("browser");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 try {
			OR.load(fil);
			OR.getProperty("bmlbtn");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}

}
