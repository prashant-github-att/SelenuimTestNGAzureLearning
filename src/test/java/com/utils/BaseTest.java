package com.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.configs.TestConfigVariable;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	
	
	
	@BeforeSuite(groups = {"regression","functional"})
	public void beforeSuite(){
		
		System.out.println("BASE Class : Before Suite which Browser");
		
	
	}
	
	@AfterSuite(groups = {"regression","functional"})
	public void afterSuite(){ 
		System.out.println("BASE Class : After Suite");
	}
	

	@BeforeMethod(groups = {"regression","functional"})
	public void beforeMethod(){
		System.out.println("BASE Class : Before Method open Browser");

	}
	
	@AfterMethod(groups = {"regression","functional"})
	public void afterMethod(){ 
		System.out.println("BASE Class : After  Method close browser");
	}
	@Parameters({"browser","url"})
	@BeforeClass(groups = {"regression","functional"})
	public void browserInitiation(String browser, String url) {
		WebDriver driver =null;
		Log.info("browser Value came from TestNG xml: " + browser);
		Log.info("browser Value came from env variable by command line xml: " + TestConfigVariable.browser);
		if (browser ==null) {
			browser =TestConfigVariable.browser;
		}
		if(browser.equals("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		}
		else if(browser.equals("firefox")) {
			
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		}
		else if(browser.equals("edge")) {
			
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			
		}
		
		PageDriverProvider.getInstance().setBrowserDriver(driver);
		Log.info("Driver initiated");
		Log.info("URL for the Class from TestNg XML as parameter" + url);
		PageDriverProvider.getInstance().getPage(url);
		Log.info("URL " + url + " launched");

	}
	@AfterClass(groups = {"regression","functional"})
	public void tearDown() {
		
		Log.info("in the Tear down function and quiting Driver");
		PageDriverProvider.getInstance().getBrowserDriver().quit();
		
	}
}
