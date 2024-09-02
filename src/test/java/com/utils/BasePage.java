package com.utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	WebDriverWait wait = null;
	public void enterText(By by, String text,WebDriver driver) {

		driver.findElement(by).sendKeys(text);

	}
	
	public void enterText(WebElement element, String text) {

		element.sendKeys(text);

	}

	public void clickButton(By by,WebDriver driver) {

		driver.findElement(by).click();

	}

	public void clickButton(WebElement element) {

		element.click();

	}
	
	
	public boolean confirmPresenceOfElementByText(By by,WebDriver driver,int seconds,String text) {
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		
		//wait.until(ExpectedConditions.presenceOfElementLocated(by)).isDisplayed();
		 Log.info(wait.until(ExpectedConditions.textToBePresentInElementLocated(by, text)).toString());
		return wait.until(ExpectedConditions.textToBePresentInElementLocated(by, text));
	}

	public boolean confirmPresenceOfElementByText(WebElement element,WebDriver driver, int seconds,String text) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		return (wait.until(ExpectedConditions.textToBePresentInElement(element, text)));
		
	}

}
