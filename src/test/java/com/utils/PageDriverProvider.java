package com.utils;

import org.openqa.selenium.WebDriver;

public class PageDriverProvider {

	public static final ThreadLocal <WebDriver> driver = new ThreadLocal<>();
	
	private static PageDriverProvider pageDriverProvider=null;
	
	private PageDriverProvider() {
		
	}
	
	public static PageDriverProvider getInstance() {
		
		if(pageDriverProvider==null) {
		pageDriverProvider= new PageDriverProvider();
		}
		return(pageDriverProvider);
	}
	
	public WebDriver getBrowserDriver() {
		
		return driver.get();
	}
	
	public void setBrowserDriver(WebDriver webDriver) {
		
		driver.set(webDriver);
	}
	
	public void getPage(String url) {
		
		driver.get().get(url);
	}
}
