package com.citrix.gotomeeting.ui.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
/**
 * This class contains common methods use to verify some UI elements
 * @author bhavna
 *
 */
public class Assertions {
	/**
	 * This method is used to verify if given CSS locator is present
	 * @param webdriver
	 * @param locator
	 * @return boolean
	 */
	public static boolean isCssLocatorPresent(WebDriver webdriver, String locator){
			try{
				webdriver.findElement(By.cssSelector(locator));
				return true;
				}
			catch(Exception e){
				return false;
			}
	}
	/**
	 * This method is used to verify if given Xpath locator is present
	 * @param webdriver
	 * @param locator
	 * @return boolean
	 */
	public static boolean isXpathLocatorPresent(WebDriver webdriver,String locator){
		try{
			WebElement element = webdriver.findElement(By.xpath(locator));
			return true;
		}
		catch(Exception e){
			return false;
		}
	}
	/**
	 * This method is used to verify if given text is present
	 * @param webdriver
	 * @param element
	 * @param text
	 * @return boolean
	 */
	public static boolean isTextEqual(WebDriver webdriver, WebElement element,String text){
		if(element.getText().equals(text)){
			return true;
		}
		else{
			return false;
		}
	}
	/**
	 * This method waits for a certain element to appear on the page
	 * @param webdriver
	 * @param locator
	 * @param seconds
	 * @return boolean
	 */
	public static boolean waitForElement(WebDriver webdriver, String locator, int seconds){
		boolean flag = false;
		try{
			for(int ctr=0;ctr<=(seconds/1000);ctr++){
				if(isCssLocatorPresent(webdriver, locator) || isXpathLocatorPresent(webdriver, locator)){
					flag = true;
					break;
				}
				else{
					Thread.sleep(1000);
				}
			}
		}
		catch(Exception e){
			return flag;
		}//end of catch
		return flag;
	}

}
