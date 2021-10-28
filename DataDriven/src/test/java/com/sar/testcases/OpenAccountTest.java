package com.sar.testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.sar.base.TestBase;
import com.sar.utilities.TestUtils;

@Listeners(com.sar.listners.CustomListeners.class)
public class OpenAccountTest extends TestBase {
	@Test(dataProviderClass = TestUtils.class, dataProvider = "dp")
	public void openaccount(String customer, String currency, String AlertError) throws InterruptedException {
		
		click("opencust");
		selects("custname",customer);
		Thread.sleep(1000);
		selects("currency",currency);
		Thread.sleep(1000);
		click("process");
		Thread.sleep(1000);
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());	
		Thread.sleep(2000);
		Assert.assertTrue(alert.getText().contains(AlertError));
		alert.accept();
	}

}
