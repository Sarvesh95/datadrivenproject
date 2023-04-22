package com.sar.testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.sar.base.TestBase;
import com.sar.utilities.TestUtils;
@Listeners(com.sar.listners.CustomListeners.class)
public class AddCustomerTest extends TestBase {
	
	@Test(dataProviderClass = TestUtils.class, dataProvider = "dp")
	public void addCustomer(String Firstname, String Lastname, String Postcode, String AlertText,String Runmode) throws InterruptedException {
		
		if(!Runmode.equals("Y")) {
			
			throw new SkipException("Skipping the test case as the Runmode for data set is NO");
		}
		
		click("addcustom");
		type("firstname",Firstname);
		Thread.sleep(1000);
		type("lastname",Lastname);
		Thread.sleep(1000);
		type("postcode",Postcode);
		Thread.sleep(1000);
		click("submit");
		
		wait.until(ExpectedConditions.alertIsPresent());
		
		
		try {
		Alert alert = driver.switchTo().alert();
		
		Assert.assertTrue(alert.getText().contains(AlertText));	
		
		Thread.sleep(2000);

		alert.accept();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		//Assert.fail("customer not added successfully");
		
					
	}
	
	
}
