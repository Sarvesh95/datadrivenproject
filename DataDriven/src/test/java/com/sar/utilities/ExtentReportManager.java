package com.sar.utilities;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {
	
	private static ExtentReports extent;
	private static ExtentSparkReporter spark;
	
	public static ExtentReports getInstance() {
		
		if (extent == null) {
			
	   spark = new ExtentSparkReporter(System.getProperty("User.dir")+"\\test-output\\html\\Extent.html");	
	   extent = new ExtentReports();
	   
	   extent.attachReporter(spark);
	   
	   
		}
		
		return extent;
	}

}
