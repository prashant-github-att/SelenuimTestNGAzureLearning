package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utils.BasePage;
import com.utils.PageDriverProvider;

public class LoginPagePOM extends BasePage{

	WebDriver driver;

	public LoginPagePOM() {
		driver = PageDriverProvider.getInstance().getBrowserDriver();
	}

	By userNameTextBox = By.xpath("//input[@id='user-name']");
	By passwordTextBox = By.xpath("//input[@id='password']");
	By loginButton = By.xpath("//input[@id='login-button']");
	By successLable = By.xpath("//div[@class='product_label']");

	public void enterUser(String userName) {

		enterText(userNameTextBox, userName, driver);
	}

	public void enterPassword(String password) {

		enterText(passwordTextBox, password, driver);
	}

	public void clickLogin() {
		
		clickButton(loginButton, driver);
	}
	
	public boolean confirmLablePresence(String text, int waitSeconds) {
		
		return confirmPresenceOfElementByText(successLable, driver, waitSeconds, text);
		
	}

	
	
}
