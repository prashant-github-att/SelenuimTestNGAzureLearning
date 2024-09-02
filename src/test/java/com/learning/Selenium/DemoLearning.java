package com.learning.Selenium;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.swing.text.DefaultEditorKit.CutAction;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.internal.junit.ArrayAsserts;

import io.github.bonigarcia.wdm.WebDriverManager;


public class DemoLearning {
	
	public static WebDriver driver= null;
	public static WebDriverWait wait,wait1= null;
	
	public static void main (String [] args) throws InterruptedException {
	
		
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		///////////////// Mouse hover and click  ///////////////
		/*
		driver.get("https://demo.opencart.com/");
		WebElement desktop= driver.findElement(By.xpath("//a[normalize-space()='Desktops']"));
		WebElement mac= driver.findElement(By.xpath("//a[normalize-space()='Mac (1)']"));
		Actions act = new Actions(driver);		
		act.moveToElement(desktop).moveToElement(mac).click().build().perform();
		*/
		
		//////////////////Right click /////////////////////////////
		
		/*
		
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		WebElement rightButton = driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
		Actions act1 = new Actions(driver);
		
		act1.contextClick(rightButton).perform();
		driver.findElement(By.xpath("//li[@class='context-menu-item context-menu-icon context-menu-icon-copy']")).click();
		Thread.sleep(3000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		Alert a = wait.until(ExpectedConditions.alertIsPresent());
		a.accept();
		
		*/

		///////////////////// Double Click ///////////////////////////////////////
		
		/*
		driver.get("https://demoqa.com/buttons");
		WebElement doubleButton = driver.findElement(By.xpath("//button[@id='doubleClickBtn']"));
		Actions doubleClick  = new Actions(driver);
		doubleClick.doubleClick(doubleButton).perform();
		System.out.println(driver.findElement(By.xpath("//p[@id='doubleClickMessage']")).getText());
	
		*/
		
		////////////////////////// Drag and drop ////////////////////////
		
		driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
		
		
		List <WebElement> sourceButtons = driver.findElements(By.xpath("//div[@id='dropContent']/div"));
		List <WebElement> destinationButtons = driver.findElements(By.xpath("//div[@id='countries']/div"));
		Actions dragAndDrop = new Actions(driver);
		int done=0;
		for(WebElement sourceButton : sourceButtons) {
			System.out.println(sourceButton.getText());
			if (sourceButton.getText().equals("Seoul") && sourceButton.getAttribute("id").contains("box"))
			{
			for (WebElement destinationButton : destinationButtons) {
				
				if (destinationButton.getText().equals("South Korea")) {
					dragAndDrop.dragAndDrop(sourceButton, destinationButton).perform();
					if (sourceButton.getCssValue("background-color").equals("rgba(0, 255, 0, 1)"))
						System.out.println("Test Case pass ");
				}
			}
		}
			
		}
		
		///////////////////////// Dynamic web Table //////////////////////////////////////
		
		/*
		
		driver.get("https://qavbox.github.io/demo/webtable/");
		
		//all the element of 1st col
		List <WebElement> cols1= driver.findElements(By.xpath("//table[@id='table01']/tbody/tr/td[1]"));
			//all the element of 1st row 
		List <WebElement> rows1= driver.findElements(By.xpath("//table[@id='table01']/tbody/tr[1]/td"));
		
		List <WebElement> headers = driver.findElements(By.xpath("//table[@id='table01']/thead/tr/th"));
		
		for (WebElement header : headers) { 
			
			System.out.println(header.getText());
		}
		
		List <WebElement> rows = driver.findElements(By.xpath("//table[@id='table01']/tbody/tr"));
		
		for (WebElement row : rows) { 
			
			List <WebElement> cols = row.findElements(By.tagName("td"));
			for (WebElement col : cols) {
				System.out.println(col.getText());
				
				if(col.getText().equals("Coded UI")) {
					
					cols.get(0).findElement(By.tagName("input")).click();
					cols.get(4).findElement(By.tagName("input")).click();
					Thread.sleep(2000);
					System.out.println(cols.get(4).findElement(By.tagName("input")).getAttribute("value"));
					if (cols.get(4).findElement(By.tagName("input")).getAttribute("value").equalsIgnoreCase("Deleted"))
						System.out.println("Test Case passed");
					
		}
			}	
		}
		
		
		List <WebElement> rows2 = driver.findElements(By.cssSelector("#table02 tbody tr"));
		List <Integer> salary = new ArrayList<>();
		for (int i =1; i<=rows2.size();i++) {
			
			List<WebElement> cols2= driver.findElements(By.cssSelector("#table02 tbody tr:nth-child("+i+") td"));
			
			for(int j =0; j< cols2.size();j++) {
				 //System.out.println(cols2.get(j).getText());
				 if (j==5) {
					salary.add(Integer.parseInt((cols2.get(j).getText().substring(1).split(",")[0].concat(cols2.get(j).getText().substring(1).split(",")[1]))));
					// System.out.println(Integer.parseInt((cols2.get(j).getText().substring(1).split(",")[0].concat(cols2.get(j).getText().substring(1).split(",")[1]))));
				 }
			}
			
			
		}
		Collections.sort(salary);
		Collections.reverse(salary);
		System.out.println(salary.get(0));
		
		
		*/
		
		
		/////////////////// window handle ///////////////////
		
		/*
		
		driver.get("https://qavbox.github.io/demo/links/");
		
		String parentWindowHandle = driver.getWindowHandle();
		
		driver.findElement(By.xpath("/html[1]/body[1]/form[1]/fieldset[1]/div[1]/div[1]/a[1]/input[1]")).click();
		
		Set<String> getAllHandlers = driver.getWindowHandles();
			
		System.out.println(getAllHandlers.toArray()[1]);
			
		for(String currentHandle : getAllHandlers) {
			
			if (!currentHandle.equals(parentWindowHandle))
			driver.switchTo().window(currentHandle);
		}
		
		System.out.println(driver.getTitle() + driver.getCurrentUrl());

		driver.close();
		
		driver.switchTo().window(parentWindowHandle);
		
		*/
		
		///////////////// Implicit and Explicit Wait///////////////////
		
		
		/*
		
		driver.get("https://qavbox.github.io/demo/delay/");
		
		driver.findElement(By.xpath("//body/form[@id='form1']/fieldset[@id='regform']/div[1]/div[1]/input[1]")).click();
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		if (wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("two"), "I am here!")))
			System.out.println("test case pass");
		
		driver.findElement(By.xpath("//body/form[@id='form1']/fieldset[@id='regform']/div[1]/div[2]/input[1]")).click();
		
		
		/////// Implicit wait /////////
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		if (driver.findElement(By.id("delay")).getText().contains( "appeared after")) {
			System.out.println("test case pass");
		}
		
		
		FluentWait waitFlu = new FluentWait(driver);
		
		waitFlu.withTimeout(Duration.ofSeconds(30));
		
		waitFlu.pollingEvery(Duration.ofSeconds(1));
		
		wait.ignoring(NoSuchElementException.class);
	
	*/
		
		
	////////////////////////////iFrame /////////////////////////////////////
		
	/*	
	driver.get("https://qavbox.github.io/demo/iframes/");
	driver.switchTo().frame("Frame1");
	driver.findElement(By.linkText("Category1")).click();
	driver.switchTo().defaultContent();
	driver.switchTo().frame("Frame2");
	driver.findElement(By.id("frameinput")).sendKeys("Who are you");
	driver.findElement(By.linkText("Category3")).click();
	driver.switchTo().defaultContent();
	
	*/
	////////////// Alert /////////////////////////
	
	/*driver.get("https://qavbox.github.io/demo/alerts/");
	driver.findElement(By.xpath("//body/form[@id='form1']/fieldset[@id='regform']/div[1]/input[1]")).click();
	Thread.sleep(2000);
	Alert simpleAlert1 = driver.switchTo().alert();
	simpleAlert1.accept();
	driver.findElement(By.xpath("//body/form[@id='form1']/fieldset[@id='regform']/div[1]/input[1]")).click();
	wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	Alert simpleAlert2 = wait.until(ExpectedConditions.alertIsPresent());
	simpleAlert2.accept();
	
	driver.findElement(By.id("delayalert")).click();
	wait1 = new WebDriverWait( driver, Duration.ofSeconds(10));
	Alert waitedAlert1 = wait1.until(ExpectedConditions.alertIsPresent());
	waitedAlert1.accept();
	
	
	driver.findElement(By.id("confirm")).click();
	Alert confirmAlert = wait1.until(ExpectedConditions.alertIsPresent());
	confirmAlert.dismiss();
	Thread.sleep(2000);
	String temp =driver.findElement(By.id("Parademo")).getText();
	
	if(temp.contains("Cancel"))
		System.out.println("test Case Passed");
	
	driver.findElement(By.id("prompt")).click();
	Alert promptAlert = wait.until(ExpectedConditions.alertIsPresent());
	promptAlert.sendKeys("Prashant");
	promptAlert.accept();*/
	
	
	
	//////////////// Radio Button Drop down  /////////////////
	
	
	/*driver.get("https://qavalidation.com/demo-form/");
	driver.findElement(By.xpath("//input[@id='g4072-fullname']")).sendKeys("FirstName");
	driver.findElement(By.xpath("//input[@id='g4072-email']")).sendKeys("abc1@gmail.com");
	driver.findElement(By.xpath("//input[@id='g4072-phonenumber']")).sendKeys("1231231231");
	WebElement dropDown = driver.findElement(By.xpath("//select[@id='g4072-gender']"));
	Select gender = new Select(dropDown);
	System.out.println(gender.getOptions().size());
	gender.selectByValue("Female");
	List <WebElement> radioButtons = driver.findElements(By.name("g4072-yearsofexperience"));
	
	for (WebElement radioButton : radioButtons) {
		System.out.println(radioButton.getAttribute("value"));
		//radioButton.click();
		
		if(radioButton.getAttribute("value").equals("2")) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(200));
			wait.until(ExpectedConditions.visibilityOf(radioButton));
			radioButton.click();
			System.out.println(radioButton.isSelected());
		}
	
		}*/
	
	
	
	Thread.sleep(5000);
	driver.quit();
	
}
}
