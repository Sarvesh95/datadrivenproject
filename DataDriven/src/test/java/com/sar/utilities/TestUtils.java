package com.sar.utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;

import com.sar.base.TestBase;

public class TestUtils extends TestBase  {
	
	

	public static void screencapture(String Methodname) {
		
		File srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File dstfile = new File("C:/Users/sarve/git/datadrivenproject/DataDriven/Screenshots/"+Methodname+".jpg");
		
		try {
			FileUtils.copyFile(srcfile, dstfile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	@DataProvider(name = "dp")
	public Object[][] getData(Method m) throws IOException {
		 
	
         String sheetname = m.getName();
		int rowCount = excel.getRowCount(sheetname);
		int colCount = excel.getColCount(sheetname);

		Object[][] data = new Object[rowCount - 1][colCount];

		for (int i = 1; i < rowCount; i++) {
			for (int j = 0; j < colCount; j++) {

				String Celldata;
				Celldata = excel.getDataString(i, j,sheetname);

				data[i - 1][j] = Celldata;
			}
			System.out.println();
		}

		return data;

	}

	public static String DateandTime() {
		
		DateFormat dateform = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		
		Date Systemdate = new Date();
		
		  String todaysdate = dateform.format(Systemdate);
		  
		  System.out.println(todaysdate);
		  
		  return todaysdate;
	}

}
