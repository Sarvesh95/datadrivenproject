package com.sar.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.sar.base.TestBase;


@Listeners(com.sar.listners.CustomListeners.class)
public class BankManagerLoginTest extends TestBase {

	@Test
	public void loginAsBankManager() {
		
		//verifyEquals("abc", "xyz");
		log.debug("Inside the Login Test");
		click("bmlbtn");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean element = driver.findElement(By.xpath(OR.getProperty("addcustom"))).isDisplayed();
		Assert.assertTrue(element);
		
	    Assert.fail("log in Test is not successful");
	}
}
