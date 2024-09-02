package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utils.BasePage;
import com.utils.PageDriverProvider;

public class LoginPagePageFactory extends BasePage{

	WebDriver driver;

	public LoginPagePageFactory() {
		driver = PageDriverProvider.getInstance().getBrowserDriver();
		PageFactory.initElements(driver, this);
	}


	@FindBy(xpath = "//input[@id='user-name']")
	WebElement userNameTextBox;
	@FindBy(xpath = "//input[@id='password']")
	WebElement passwordTextBox;
	@FindBy(xpath = "//input[@id='login-button']")
	WebElement loginButton;
	@FindBy(xpath = "//div[@class='product_label']")
	WebElement successLable; 
	public void enterUser(String userName) {

		enterText(userNameTextBox, userName);
	}

	public void enterPassword(String password) {

		enterText(passwordTextBox, password);
	}

	public void clickLogin() {
		
		clickButton(loginButton);
	}
	
	public boolean confirmLablePresence(String text, int waitSeconds) {
		
		return confirmPresenceOfElementByText(successLable, driver, waitSeconds, text);
		
	}

	

}
