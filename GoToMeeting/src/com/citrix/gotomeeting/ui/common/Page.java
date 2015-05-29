package com.citrix.gotomeeting.ui.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * This is the base class inherited by all page objects 
 * @author bhavna
 *
 */
public class Page {
	
	private static WebDriver webdriver = null;
	/**
	 * This method is used to create a single webdriver instance
	 * @return WebDriver
	 */
	public static WebDriver getWebDriver(){
		if(webdriver == null)
			System.setProperty("webdriver.chrome.driver", "src/com/citrix/gotomeeting/ui/chromedriver");
			webdriver = new ChromeDriver();
		return webdriver;
	}
	
	/**
	 * This method is used to terminate the WebDriver instance
	 */
	public void killDriver(){
		webdriver.quit();
	}

}
