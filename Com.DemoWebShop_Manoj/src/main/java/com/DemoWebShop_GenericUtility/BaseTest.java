package com.DemoWebShop_GenericUtility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.DemoWebShop_POM.Home_Page;
import com.DemoWebShop_POM.Login_Page;
import com.DemoWebShop_POM.Welcome_Page;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.Status;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseTest {
	
	public WebDriver driver;
	public static WebDriver sDriver;
	public ExtentReports reports;
	public ExtentTest test;
	public FileUtility fileutility = new FileUtility();
	public Welcome_Page welcomepage;
	public Login_Page loginpage;
	public Home_Page homepage;
	public WebDriver_Utility webdriverutility = new WebDriver_Utility();
	
	@BeforeSuite
	public void beforeSuite()
	{
		System.out.println("Before suite ---- Starts Database connection");
	}
	
	@BeforeTest
	public void beforeTest()
	{
		System.out.println("Before Test ---- Reports Generation");
//		ExtentSparkReporter spark = new ExtentSparkReporter(FrameWorkConstants.reportsPath);
//		reports = new ExtentReports();
//		reports.attachReporter(spark);
//		test = reports.createTest("DemoWebShop");
	}
	
	@BeforeClass
	public void beforeClass() throws IOException
	{
		System.out.println("Before class --- Launch Browser");
		
		String browser = fileutility.readDataFromPropertyFile("browsername");
		String url = fileutility.readDataFromPropertyFile("url");
		
		// getting data from cmd line
//		String browser = System.getProperty("browsername");
//		String url = System.getProperty("url");
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.out.println("Chrome Launched");
			driver = new ChromeDriver();
//			test.log(Status.INFO, "Browser launched");
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			System.out.println("Edge Launched");
			driver = new EdgeDriver();
		}
		else {
			System.out.println("Enter valid browser name");
		}
		
		driver.manage().window().maximize();
//		test.log(Status.INFO, "Browser Maximized");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		sDriver = driver;
		
		driver.get(url);
//		test.log(Status.INFO, "Navigated to web page");
		
	}
	
	@BeforeMethod
	public void beforeMethod() throws IOException
	{
		System.out.println("Before method --- Login to the app");
		
		welcomepage = new Welcome_Page(driver);
		welcomepage.getLoginBtn().click();
//		test.log(Status.INFO, "Clicked on the login button");
		
		loginpage = new Login_Page(driver);
		loginpage.getEmailTextField().sendKeys(fileutility.readDataFromPropertyFile("username"));
		loginpage.getPasswordTextField().sendKeys(fileutility.readDataFromPropertyFile("password"));
		loginpage.getLoginBtn().click();
//		test.log(Status.INFO, "Login successfull");
		
		homepage = new Home_Page(driver);
		
	}
	
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("After method  ---  Logout from the app");
		homepage.getLogoutBtn().click();
//		test.log(Status.INFO, "Logout successfull");

	}
	
	@AfterClass
	public void afterClass() throws InterruptedException
	{
		System.out.println("After class --- Close the browser");
		Thread.sleep(3000);
		driver.quit();
//		test.log(Status.INFO, "Closed the browser");
	}
	
	@AfterTest
	public void afterTest()
	{
		System.out.println("After test --- Report generation ends");
//		reports.flush();
	}
	
	@AfterSuite
	public void afterSuite()
	{
		System.out.println("After suite --- Ends Database connection");
	}

}
