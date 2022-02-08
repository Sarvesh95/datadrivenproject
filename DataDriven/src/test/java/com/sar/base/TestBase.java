package com.sar.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.sar.utilities.ExcelReader;
import com.sar.utilities.ExtentReportManager;
import com.sar.utilities.TestUtils;

import org.apache.log4j.Logger;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties Config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream file ;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static ExcelReader excel = new ExcelReader("C:\\Users\\sarve\\git\\datadrivenproject\\DataDriven\\src\\test\\resources\\excel\\testdata.xlsx");
	public static WebDriverWait wait;
	public ExtentReports rep = ExtentReportManager.getInstance();
	public static ExtentTest test;
	@BeforeSuite
	public void setUp() {
		
		if (driver == null) {
			
			try {
				file = new FileInputStream("C:\\Users\\sarve\\eclipse-workspace\\DataDriven\\src\\test\\resources\\properties\\Config.properties");
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				Config.load(file);
				log.debug("Config file Loaded !!!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				file = new FileInputStream("C:\\Users\\sarve\\eclipse-workspace\\DataDriven\\src\\test\\resources\\properties\\OR.properties");
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			try {
				OR.load(file);
				log.debug("OR file Loaded !!!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(Config.getProperty("browser").equals("chrome")){
				
				System.setProperty("webdriver.chrome.driver","C:\\Users\\sarve\\eclipse-workspace\\DataDrivenFramework\\src\\test\\resources\\executables\\chromedriver.exe");
				driver = new ChromeDriver();
				Actions act = new Actions(driver);
			}
			else if(Config.getProperty("browser").equals("firefox")) {
				System.setProperty("webdriver.gecko.driver","C:\\Users\\sarve\\eclipse-workspace\\DataDriven\\src\\test\\resources\\executables\\geckodriver.exe");
				driver = new FirefoxDriver();
				Actions act = new Actions(driver);
			}
			else if(Config.getProperty("browser").equals("edge")){
				System.setProperty("webdriver.edge.driver","C:\\Users\\sarve\\eclipse-workspace\\DataDriven\\src\\test\\resources\\executables\\msedgedriver.exe");
				driver = new EdgeDriver();
				Actions act = new Actions(driver);
			}
			
			log.debug("Browser Launched !!!");
			
			driver.get(Config.getProperty("testsiteUrl"));
			log.debug("Navigated to"+Config.getProperty("testsiteUrl"));
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(Config.getProperty("implicitly.wait")), TimeUnit.SECONDS);
			wait = new WebDriverWait(driver,5);
			
			
		}
	}
	
	public void click(String locator) {
		
		driver.findElement(By.xpath(OR.getProperty(locator))).click();
		test.log(Status.INFO, "clicking on : "+locator);
	}
	
	public void type(String locator, String value) {
		
		driver.findElement(By.xpath(OR.getProperty(locator))).sendKeys(value);
		test.log(Status.INFO, "typing in : "+locator+" and entered value as "+value);
	}
	
	static WebElement dropdown;
	public void selects(String locator, String value) {
		
		dropdown = driver.findElement(By.xpath(OR.getProperty(locator)));
	
		Select select = new Select(dropdown);
		select.selectByVisibleText(value);
		
		test.log(Status.INFO, "Selecting from dropdown : "+locator+" and value is "+value);
	
	}
	public void verifyEquals(String Actual, String Expected) {
		try {
		Assert.assertEquals(Actual, Expected);
		}
		catch(Throwable t){
						
			String date = TestUtils.DateandTime();
						
			TestUtils.screencapture("screenshot_"+date);

			test.log(Status.FAIL, "verification failed with exception : "+t.getMessage()+"<br>");
			test.addScreenCaptureFromPath("C:/Users/sarve/eclipse-workspace/DataDriven/Screenshots/screenshot_"+date+".jpg");
		}
	}
	
		@AfterSuite
	public void TearDown() {
		
		if(driver!=null) {
		driver.close();
		driver.quit();
	}
		log.debug("Test Execution Completed");
	}
}
	
