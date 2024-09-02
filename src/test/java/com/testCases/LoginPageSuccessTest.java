package com.testCases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.pages.LoginPagePOM;
import com.pages.LoginPagePageFactory;
import com.utils.BaseTest;
import com.utils.Log;

public class LoginPageSuccessTest extends BaseTest {

	@Test(groups = {"functional"})
	public void successLogin() {
		//LoginPagePOM loginPage = new LoginPagePOM();
		LoginPagePageFactory loginPage = new LoginPagePageFactory();
		Log.info("Entering User Name");
		loginPage.enterUser("standard_user");
		Log.info("Entering Password");
		loginPage.enterPassword("secret_sauce");
		Log.info("Clicking Login button ");
		loginPage.clickLogin();
		
		assertEquals(loginPage.confirmLablePresence("Products", 1),true);
		
		
	}
	
	
	
	
	/*@Test(groups = {"functional"})
	public void test2() {
		System.out.println("ExampleTC1 : test2");
	}
	
	@Test(groups = {"regression"},dependsOnMethods = {"test1"})
	public void test3() {
		System.out.println("ExampleTC1 : test3");
	}*/
}
